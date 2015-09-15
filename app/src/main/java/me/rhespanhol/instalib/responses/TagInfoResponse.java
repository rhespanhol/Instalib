package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import me.rhespanhol.instalib.entities.TagInfo;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class TagInfoResponse {

    @SerializedName("data")
    private TagInfo tagInfo;

    public TagInfo getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.tagInfo = tagInfo;
    }
}
