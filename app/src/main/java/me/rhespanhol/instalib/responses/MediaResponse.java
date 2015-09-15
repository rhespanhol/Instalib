package me.rhespanhol.instalib.responses;

import me.rhespanhol.instalib.entities.Media;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class MediaResponse extends BaseResponse {

    Media data;

    public Media getMedia() {
        return data;
    }

    public void setMedia(Media data) {
        this.data = data;
    }
}
