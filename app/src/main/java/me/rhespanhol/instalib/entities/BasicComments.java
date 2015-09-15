package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class BasicComments {

    @SerializedName("data")
    protected List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setData(List<Comment> data) {
        this.comments = data;
    }
}
