
package com.example.myapplication.MyPostRecylerViewModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPostRecylerViewResponce {

    @SerializedName("MyPosts")
    @Expose
    private List<MyPost> myPosts = new ArrayList<>();

    public List<MyPost> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<MyPost> myPosts) {
        this.myPosts = myPosts;
    }

}
