package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.rhespanhol.instalib.entities.BasicUser;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class LikesResponse extends BaseResponse {

    @SerializedName("data")
    private List<BasicUser> likes;

    public List<BasicUser> getLikes() {
        return likes;
    }

    public void setLikes(List<BasicUser> likes) {
        this.likes = likes;
    }
}
