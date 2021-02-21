package com.jovialway.bookexchange.RecyclerAddBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("amounth")
    @Expose
    private String amounth;
    @SerializedName("book_catagory")
    @Expose
    private String bookCatagory;
    @SerializedName("book_image")
    @Expose
    private Object bookImage;
    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("book_writer")
    @Expose
    private String bookWriter;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private Integer f151id;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("pablisher")
    @Expose
    private String pablisher;
    @SerializedName("roll")
    @Expose
    private String roll;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public Integer getId() {
        return this.f151id;
    }

    public void setId(Integer id) {
        this.f151id = id;
    }

    public Object getBookImage() {
        return this.bookImage;
    }

    public void setBookImage(Object bookImage2) {
        this.bookImage = bookImage2;
    }

    public String getBookCatagory() {
        return this.bookCatagory;
    }

    public void setBookCatagory(String bookCatagory2) {
        this.bookCatagory = bookCatagory2;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName2) {
        this.bookName = bookName2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getBookWriter() {
        return this.bookWriter;
    }

    public void setBookWriter(String bookWriter2) {
        this.bookWriter = bookWriter2;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile2) {
        this.mobile = mobile2;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail2) {
        this.userEmail = userEmail2;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division2) {
        this.division = division2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city2) {
        this.city = city2;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public String getPablisher() {
        return this.pablisher;
    }

    public void setPablisher(String pablisher2) {
        this.pablisher = pablisher2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId2) {
        this.userId = userId2;
    }

    public String getRoll() {
        return this.roll;
    }

    public void setRoll(String roll2) {
        this.roll = roll2;
    }

    public String getAmounth() {
        return this.amounth;
    }

    public void setAmounth(String amounth2) {
        this.amounth = amounth2;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt2) {
        this.createdAt = createdAt2;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt2) {
        this.updatedAt = updatedAt2;
    }
}
