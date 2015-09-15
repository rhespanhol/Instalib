package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Images {

    @SerializedName("low_resolution")
    private MediaContent lowResolution;

    private MediaContent thumbnail;

    @SerializedName("standard_resolution")
    private MediaContent standardResolution;

    public MediaContent getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(MediaContent lowResolution) {
        this.lowResolution = lowResolution;
    }

    public MediaContent getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MediaContent thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MediaContent getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(MediaContent standardResolution) {
        this.standardResolution = standardResolution;
    }
}
