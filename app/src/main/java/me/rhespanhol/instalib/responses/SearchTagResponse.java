package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.rhespanhol.instalib.entities.TagInfo;


/**
 * Created by rhespanhol on 14/09/15.
 */
public class SearchTagResponse extends BaseResponse {

    @SerializedName("data")
    private List<TagInfo> tagInfoList;

    public List<TagInfo> getTagInfoList() {
        return tagInfoList;
    }

    public void setTagInfoList(List<TagInfo> tagInfoList) {
        this.tagInfoList = tagInfoList;
    }
}
