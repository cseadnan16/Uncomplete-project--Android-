
package com.example.myapplication.AdPostRecylerViewResponce;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdRecylerViewResponse {

    @SerializedName("activePosts")
    @Expose
    private List<ActivePost> activePosts = new ArrayList<>();

    public List<ActivePost> getActivePosts() {
        return activePosts;
    }

    public void setActivePosts(List<ActivePost> activePosts) {
        this.activePosts = activePosts;
    }

}
