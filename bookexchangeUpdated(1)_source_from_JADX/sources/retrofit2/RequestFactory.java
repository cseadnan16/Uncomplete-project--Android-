package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

final class RequestFactory {
    private final HttpUrl baseUrl;
    @Nullable
    private final MediaType contentType;
    private final boolean hasBody;
    @Nullable
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    @Nullable
    private final String relativeUrl;

    static RequestFactory parseAnnotations(Retrofit retrofit, Method method2) {
        return new Builder(retrofit, method2).build();
    }

    RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    /* access modifiers changed from: package-private */
    public Request create(Object[] args) throws IOException {
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int argumentCount = args.length;
        if (argumentCount == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
            List<Object> argumentList = new ArrayList<>(argumentCount);
            for (int p = 0; p < argumentCount; p++) {
                argumentList.add(args[p]);
                parameterHandlerArr[p].apply(requestBuilder, args[p]);
            }
            return requestBuilder.get().tag(Invocation.class, new Invocation(this.method, argumentList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + argumentCount + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
    }

    static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        @Nullable
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        @Nullable
        Headers headers;
        @Nullable
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        @Nullable
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        @Nullable
        String relativeUrl;
        @Nullable
        Set<String> relativeUrlParamNames;
        final Retrofit retrofit;

        Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        /* access modifiers changed from: package-private */
        public RequestFactory build() {
            for (Annotation annotation : this.methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw C1244Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw C1244Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int parameterCount = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[parameterCount];
                for (int p = 0; p < parameterCount; p++) {
                    this.parameterHandlers[p] = parseParameter(p, this.parameterTypes[p], this.parameterAnnotationsArray[p]);
                }
                if (this.relativeUrl == null && !this.gotUrl) {
                    throw C1244Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
                } else if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw C1244Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.isFormEncoded && !this.gotField) {
                    throw C1244Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.isMultipart || this.gotPart) {
                    return new RequestFactory(this);
                } else {
                    throw C1244Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw C1244Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] headersToParse = ((retrofit2.http.Headers) annotation).value();
                if (headersToParse.length != 0) {
                    this.headers = parseHeaders(headersToParse);
                    return;
                }
                throw C1244Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof Multipart) {
                if (!this.isFormEncoded) {
                    this.isMultipart = true;
                    return;
                }
                throw C1244Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof FormUrlEncoded)) {
            } else {
                if (!this.isMultipart) {
                    this.isFormEncoded = true;
                    return;
                }
                throw C1244Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void parseHttpMethodAndPath(String httpMethod2, String value, boolean hasBody2) {
            String str = this.httpMethod;
            if (str == null) {
                this.httpMethod = httpMethod2;
                this.hasBody = hasBody2;
                if (!value.isEmpty()) {
                    int question = value.indexOf(63);
                    if (question != -1 && question < value.length() - 1) {
                        String queryParams = value.substring(question + 1);
                        if (PARAM_URL_REGEX.matcher(queryParams).find()) {
                            throw C1244Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", queryParams);
                        }
                    }
                    this.relativeUrl = value;
                    this.relativeUrlParamNames = parsePathParameters(value);
                    return;
                }
                return;
            }
            throw C1244Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", str, httpMethod2);
        }

        private Headers parseHeaders(String[] headers2) {
            Headers.Builder builder = new Headers.Builder();
            for (String header : headers2) {
                int colon = header.indexOf(58);
                if (colon == -1 || colon == 0 || colon == header.length() - 1) {
                    throw C1244Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", header);
                }
                String headerName = header.substring(0, colon);
                String headerValue = header.substring(colon + 1).trim();
                if ("Content-Type".equalsIgnoreCase(headerName)) {
                    try {
                        this.contentType = MediaType.get(headerValue);
                    } catch (IllegalArgumentException e) {
                        throw C1244Utils.methodError(this.method, e, "Malformed content type: %s", headerValue);
                    }
                } else {
                    builder.add(headerName, headerValue);
                }
            }
            return builder.build();
        }

        private ParameterHandler<?> parseParameter(int p, Type parameterType, @Nullable Annotation[] annotations) {
            ParameterHandler<?> result = null;
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    ParameterHandler<?> annotationAction = parseParameterAnnotation(p, parameterType, annotations, annotation);
                    if (annotationAction != null) {
                        if (result == null) {
                            result = annotationAction;
                        } else {
                            throw C1244Utils.parameterError(this.method, p, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            }
            if (result != null) {
                return result;
            }
            throw C1244Utils.parameterError(this.method, p, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private ParameterHandler<?> parseParameterAnnotation(int p, Type type, Annotation[] annotations, Annotation annotation) {
            if (annotation instanceof Url) {
                validateResolvableType(p, type);
                if (this.gotUrl) {
                    throw C1244Utils.parameterError(this.method, p, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.gotPath) {
                    throw C1244Utils.parameterError(this.method, p, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.gotQuery) {
                    throw C1244Utils.parameterError(this.method, p, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw C1244Utils.parameterError(this.method, p, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw C1244Utils.parameterError(this.method, p, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.relativeUrl == null) {
                    this.gotUrl = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.RelativeUrl();
                    }
                    throw C1244Utils.parameterError(this.method, p, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw C1244Utils.parameterError(this.method, p, "@Url cannot be used with @%s URL", this.httpMethod);
                }
            } else if (annotation instanceof Path) {
                validateResolvableType(p, type);
                if (this.gotQuery) {
                    throw C1244Utils.parameterError(this.method, p, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw C1244Utils.parameterError(this.method, p, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw C1244Utils.parameterError(this.method, p, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.gotUrl) {
                    throw C1244Utils.parameterError(this.method, p, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.relativeUrl != null) {
                    this.gotPath = true;
                    Path path = (Path) annotation;
                    String name = path.value();
                    validatePathName(p, name);
                    return new ParameterHandler.Path(name, this.retrofit.stringConverter(type, annotations), path.encoded());
                } else {
                    throw C1244Utils.parameterError(this.method, p, "@Path can only be used with relative url on @%s", this.httpMethod);
                }
            } else if (annotation instanceof Query) {
                validateResolvableType(p, type);
                Query query = (Query) annotation;
                String name2 = query.value();
                boolean encoded = query.encoded();
                Class<?> rawParameterType = C1244Utils.getRawType(type);
                this.gotQuery = true;
                if (Iterable.class.isAssignableFrom(rawParameterType)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.Query(name2, this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations), encoded).iterable();
                    }
                    Method method2 = this.method;
                    throw C1244Utils.parameterError(method2, p, rawParameterType.getSimpleName() + " must include generic type (e.g., " + rawParameterType.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawParameterType.isArray()) {
                    return new ParameterHandler.Query(name2, this.retrofit.stringConverter(type, annotations), encoded);
                } else {
                    return new ParameterHandler.Query(name2, this.retrofit.stringConverter(boxIfPrimitive(rawParameterType.getComponentType()), annotations), encoded).array();
                }
            } else if (annotation instanceof QueryName) {
                validateResolvableType(p, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> rawParameterType2 = C1244Utils.getRawType(type);
                this.gotQueryName = true;
                if (Iterable.class.isAssignableFrom(rawParameterType2)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.QueryName(this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations), encoded2).iterable();
                    }
                    Method method3 = this.method;
                    throw C1244Utils.parameterError(method3, p, rawParameterType2.getSimpleName() + " must include generic type (e.g., " + rawParameterType2.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawParameterType2.isArray()) {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, annotations), encoded2);
                } else {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(rawParameterType2.getComponentType()), annotations), encoded2).array();
                }
            } else if (annotation instanceof QueryMap) {
                validateResolvableType(p, type);
                Class<?> rawParameterType3 = C1244Utils.getRawType(type);
                this.gotQueryMap = true;
                if (Map.class.isAssignableFrom(rawParameterType3)) {
                    Type mapType = C1244Utils.getSupertype(type, rawParameterType3, Map.class);
                    if (mapType instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) mapType;
                        Type keyType = C1244Utils.getParameterUpperBound(0, parameterizedType);
                        if (String.class == keyType) {
                            return new ParameterHandler.QueryMap(this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(1, parameterizedType), annotations), ((QueryMap) annotation).encoded());
                        }
                        Method method4 = this.method;
                        throw C1244Utils.parameterError(method4, p, "@QueryMap keys must be of type String: " + keyType, new Object[0]);
                    }
                    throw C1244Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw C1244Utils.parameterError(this.method, p, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Header) {
                validateResolvableType(p, type);
                String name3 = ((Header) annotation).value();
                Class<?> rawParameterType4 = C1244Utils.getRawType(type);
                if (Iterable.class.isAssignableFrom(rawParameterType4)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.Header(name3, this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations)).iterable();
                    }
                    Method method5 = this.method;
                    throw C1244Utils.parameterError(method5, p, rawParameterType4.getSimpleName() + " must include generic type (e.g., " + rawParameterType4.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawParameterType4.isArray()) {
                    return new ParameterHandler.Header(name3, this.retrofit.stringConverter(type, annotations));
                } else {
                    return new ParameterHandler.Header(name3, this.retrofit.stringConverter(boxIfPrimitive(rawParameterType4.getComponentType()), annotations)).array();
                }
            } else if (annotation instanceof HeaderMap) {
                validateResolvableType(p, type);
                Class<?> rawParameterType5 = C1244Utils.getRawType(type);
                if (Map.class.isAssignableFrom(rawParameterType5)) {
                    Type mapType2 = C1244Utils.getSupertype(type, rawParameterType5, Map.class);
                    if (mapType2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) mapType2;
                        Type keyType2 = C1244Utils.getParameterUpperBound(0, parameterizedType2);
                        if (String.class == keyType2) {
                            return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(1, parameterizedType2), annotations));
                        }
                        Method method6 = this.method;
                        throw C1244Utils.parameterError(method6, p, "@HeaderMap keys must be of type String: " + keyType2, new Object[0]);
                    }
                    throw C1244Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw C1244Utils.parameterError(this.method, p, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Field) {
                validateResolvableType(p, type);
                if (this.isFormEncoded) {
                    Field field = (Field) annotation;
                    String name4 = field.value();
                    boolean encoded3 = field.encoded();
                    this.gotField = true;
                    Class<?> rawParameterType6 = C1244Utils.getRawType(type);
                    if (Iterable.class.isAssignableFrom(rawParameterType6)) {
                        if (type instanceof ParameterizedType) {
                            return new ParameterHandler.Field(name4, this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations), encoded3).iterable();
                        }
                        Method method7 = this.method;
                        throw C1244Utils.parameterError(method7, p, rawParameterType6.getSimpleName() + " must include generic type (e.g., " + rawParameterType6.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!rawParameterType6.isArray()) {
                        return new ParameterHandler.Field(name4, this.retrofit.stringConverter(type, annotations), encoded3);
                    } else {
                        return new ParameterHandler.Field(name4, this.retrofit.stringConverter(boxIfPrimitive(rawParameterType6.getComponentType()), annotations), encoded3).array();
                    }
                } else {
                    throw C1244Utils.parameterError(this.method, p, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof FieldMap) {
                validateResolvableType(p, type);
                if (this.isFormEncoded) {
                    Class<?> rawParameterType7 = C1244Utils.getRawType(type);
                    if (Map.class.isAssignableFrom(rawParameterType7)) {
                        Type mapType3 = C1244Utils.getSupertype(type, rawParameterType7, Map.class);
                        if (mapType3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) mapType3;
                            Type keyType3 = C1244Utils.getParameterUpperBound(0, parameterizedType3);
                            if (String.class == keyType3) {
                                Converter<?, String> valueConverter = this.retrofit.stringConverter(C1244Utils.getParameterUpperBound(1, parameterizedType3), annotations);
                                this.gotField = true;
                                return new ParameterHandler.FieldMap(valueConverter, ((FieldMap) annotation).encoded());
                            }
                            Method method8 = this.method;
                            throw C1244Utils.parameterError(method8, p, "@FieldMap keys must be of type String: " + keyType3, new Object[0]);
                        }
                        throw C1244Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw C1244Utils.parameterError(this.method, p, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw C1244Utils.parameterError(this.method, p, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof Part) {
                validateResolvableType(p, type);
                if (this.isMultipart) {
                    Part part = (Part) annotation;
                    this.gotPart = true;
                    String partName = part.value();
                    Class<?> rawParameterType8 = C1244Utils.getRawType(type);
                    if (!partName.isEmpty()) {
                        Headers headers2 = Headers.m96of("Content-Disposition", "form-data; name=\"" + partName + "\"", "Content-Transfer-Encoding", part.encoding());
                        if (Iterable.class.isAssignableFrom(rawParameterType8)) {
                            if (type instanceof ParameterizedType) {
                                Type iterableType = C1244Utils.getParameterUpperBound(0, (ParameterizedType) type);
                                if (!MultipartBody.Part.class.isAssignableFrom(C1244Utils.getRawType(iterableType))) {
                                    return new ParameterHandler.Part(headers2, this.retrofit.requestBodyConverter(iterableType, annotations, this.methodAnnotations)).iterable();
                                }
                                throw C1244Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            Method method9 = this.method;
                            throw C1244Utils.parameterError(method9, p, rawParameterType8.getSimpleName() + " must include generic type (e.g., " + rawParameterType8.getSimpleName() + "<String>)", new Object[0]);
                        } else if (rawParameterType8.isArray()) {
                            Class<?> arrayComponentType = boxIfPrimitive(rawParameterType8.getComponentType());
                            if (!MultipartBody.Part.class.isAssignableFrom(arrayComponentType)) {
                                return new ParameterHandler.Part(headers2, this.retrofit.requestBodyConverter(arrayComponentType, annotations, this.methodAnnotations)).array();
                            }
                            throw C1244Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!MultipartBody.Part.class.isAssignableFrom(rawParameterType8)) {
                            return new ParameterHandler.Part(headers2, this.retrofit.requestBodyConverter(type, annotations, this.methodAnnotations));
                        } else {
                            throw C1244Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(rawParameterType8)) {
                        if (!(type instanceof ParameterizedType)) {
                            Method method10 = this.method;
                            throw C1244Utils.parameterError(method10, p, rawParameterType8.getSimpleName() + " must include generic type (e.g., " + rawParameterType8.getSimpleName() + "<String>)", new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(C1244Utils.getRawType(C1244Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                            return ParameterHandler.RawPart.INSTANCE.iterable();
                        } else {
                            throw C1244Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (rawParameterType8.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(rawParameterType8.getComponentType())) {
                            return ParameterHandler.RawPart.INSTANCE.array();
                        }
                        throw C1244Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (MultipartBody.Part.class.isAssignableFrom(rawParameterType8)) {
                        return ParameterHandler.RawPart.INSTANCE;
                    } else {
                        throw C1244Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw C1244Utils.parameterError(this.method, p, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof PartMap) {
                validateResolvableType(p, type);
                if (this.isMultipart) {
                    this.gotPart = true;
                    Class<?> rawParameterType9 = C1244Utils.getRawType(type);
                    if (Map.class.isAssignableFrom(rawParameterType9)) {
                        Type mapType4 = C1244Utils.getSupertype(type, rawParameterType9, Map.class);
                        if (mapType4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) mapType4;
                            Type keyType4 = C1244Utils.getParameterUpperBound(0, parameterizedType4);
                            if (String.class == keyType4) {
                                Type valueType = C1244Utils.getParameterUpperBound(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(C1244Utils.getRawType(valueType))) {
                                    return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(valueType, annotations, this.methodAnnotations), ((PartMap) annotation).encoding());
                                }
                                throw C1244Utils.parameterError(this.method, p, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            Method method11 = this.method;
                            throw C1244Utils.parameterError(method11, p, "@PartMap keys must be of type String: " + keyType4, new Object[0]);
                        }
                        throw C1244Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw C1244Utils.parameterError(this.method, p, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw C1244Utils.parameterError(this.method, p, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (!(annotation instanceof Body)) {
                return null;
            } else {
                validateResolvableType(p, type);
                if (this.isFormEncoded || this.isMultipart) {
                    throw C1244Utils.parameterError(this.method, p, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.gotBody) {
                    try {
                        Converter<?, RequestBody> converter = this.retrofit.requestBodyConverter(type, annotations, this.methodAnnotations);
                        this.gotBody = true;
                        return new ParameterHandler.Body(converter);
                    } catch (RuntimeException e) {
                        throw C1244Utils.parameterError(this.method, e, p, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw C1244Utils.parameterError(this.method, p, "Multiple @Body method annotations found.", new Object[0]);
                }
            }
        }

        private void validateResolvableType(int p, Type type) {
            if (C1244Utils.hasUnresolvableType(type)) {
                throw C1244Utils.parameterError(this.method, p, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void validatePathName(int p, String name) {
            if (!PARAM_NAME_REGEX.matcher(name).matches()) {
                throw C1244Utils.parameterError(this.method, p, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), name);
            } else if (!this.relativeUrlParamNames.contains(name)) {
                throw C1244Utils.parameterError(this.method, p, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, name);
            }
        }

        static Set<String> parsePathParameters(String path) {
            Matcher m = PARAM_URL_REGEX.matcher(path);
            Set<String> patterns = new LinkedHashSet<>();
            while (m.find()) {
                patterns.add(m.group(1));
            }
            return patterns;
        }

        private static Class<?> boxIfPrimitive(Class<?> type) {
            if (Boolean.TYPE == type) {
                return Boolean.class;
            }
            if (Byte.TYPE == type) {
                return Byte.class;
            }
            if (Character.TYPE == type) {
                return Character.class;
            }
            if (Double.TYPE == type) {
                return Double.class;
            }
            if (Float.TYPE == type) {
                return Float.class;
            }
            if (Integer.TYPE == type) {
                return Integer.class;
            }
            if (Long.TYPE == type) {
                return Long.class;
            }
            if (Short.TYPE == type) {
                return Short.class;
            }
            return type;
        }
    }
}
