package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Pagination {

    @SerializedName("next_url")
    protected String nextUrl;

    @SerializedName("next_max_id")
    private String nextMaxId;

    public String getNextUrl() {
        return nextUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }
}
