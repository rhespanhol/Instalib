package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Comment {

    @SerializedName("created_time")
    private long createdTime;

    private String text;

    private BasicUser from;

    private String id;

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BasicUser getFrom() {
        return from;
    }

    public void setFrom(BasicUser from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
