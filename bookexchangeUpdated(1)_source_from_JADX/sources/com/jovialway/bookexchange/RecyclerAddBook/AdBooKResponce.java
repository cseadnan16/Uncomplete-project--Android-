package com.jovialway.bookexchange.RecyclerAddBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AdBooKResponce {
    @SerializedName("base_url")
    @Expose
    private String baseUrl;
    @SerializedName("books")
    @Expose
    private List<Book> books = null;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status2) {
        this.status = status2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl2) {
        this.baseUrl = baseUrl2;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total2) {
        this.total = total2;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count2) {
        this.count = count2;
    }

    public Integer getPerPage() {
        return this.perPage;
    }

    public void setPerPage(Integer perPage2) {
        this.perPage = perPage2;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage2) {
        this.currentPage = currentPage2;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(Integer totalPages2) {
        this.totalPages = totalPages2;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books2) {
        this.books = books2;
    }
}
