package com.google.firebase.database.tubesock;

import android.util.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
class WebSocketHandshake {
    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders = null;
    private String nonce = null;
    private String protocol = null;
    private URI url = null;

    public WebSocketHandshake(URI url2, String protocol2, Map<String, String> extraHeaders2) {
        this.url = url2;
        this.protocol = protocol2;
        this.extraHeaders = extraHeaders2;
        this.nonce = createNonce();
    }

    public byte[] getHandshake() {
        String str;
        String path = this.url.getPath();
        String query = this.url.getQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        if (query == null) {
            str = "";
        } else {
            str = "?" + query;
        }
        sb.append(str);
        String path2 = sb.toString();
        String host = this.url.getHost();
        if (this.url.getPort() != -1) {
            host = host + ":" + this.url.getPort();
        }
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("Host", host);
        header.put("Upgrade", "websocket");
        header.put("Connection", "Upgrade");
        header.put("Sec-WebSocket-Version", WEBSOCKET_VERSION);
        header.put("Sec-WebSocket-Key", this.nonce);
        String str2 = this.protocol;
        if (str2 != null) {
            header.put("Sec-WebSocket-Protocol", str2);
        }
        Map<String, String> map = this.extraHeaders;
        if (map != null) {
            for (String fieldName : map.keySet()) {
                if (!header.containsKey(fieldName)) {
                    header.put(fieldName, this.extraHeaders.get(fieldName));
                }
            }
        }
        byte[] tmpHandShakeBytes = ((("GET " + path2 + " HTTP/1.1\r\n") + generateHeader(header)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] handshakeBytes = new byte[tmpHandShakeBytes.length];
        System.arraycopy(tmpHandShakeBytes, 0, handshakeBytes, 0, tmpHandShakeBytes.length);
        return handshakeBytes;
    }

    private String generateHeader(LinkedHashMap<String, String> headers) {
        String header = new String();
        for (String fieldName : headers.keySet()) {
            header = header + fieldName + ": " + headers.get(fieldName) + "\r\n";
        }
        return header;
    }

    private String createNonce() {
        byte[] nonce2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            nonce2[i] = (byte) rand(0, 255);
        }
        return Base64.encodeToString(nonce2, 2);
    }

    public void verifyServerStatusLine(String statusLine) {
        int statusCode = Integer.parseInt(statusLine.substring(9, 12));
        if (statusCode == 407) {
            throw new WebSocketException("connection failed: proxy authentication not supported");
        } else if (statusCode == 404) {
            throw new WebSocketException("connection failed: 404 not found");
        } else if (statusCode != 101) {
            throw new WebSocketException("connection failed: unknown status code " + statusCode);
        }
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> lowercaseHeaders) {
        if (!"websocket".equals(lowercaseHeaders.get("upgrade"))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
        } else if (!"upgrade".equals(lowercaseHeaders.get("connection"))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
        }
    }

    private int rand(int min, int max) {
        return (int) ((Math.random() * ((double) max)) + ((double) min));
    }
}
