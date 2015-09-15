package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.MediaListResponse;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class LikedMedia extends MediaListResponse {

    public List<Media> getLikedMediaList() {
        return data;
    }

    public void setData(List<Media> data) {
        this.data = data;
    }
}
