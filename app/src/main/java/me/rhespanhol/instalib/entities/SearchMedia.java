package me.rhespanhol.instalib.entities;


import java.util.List;

import me.rhespanhol.instalib.responses.MediaListResponse;

/**
 * Created by rhespanhol on 11/09/15.
 */
public class SearchMedia extends MediaListResponse {

    public List<Media> getMedia() {
        return data;
    }

    public void setData(List<Media> data) {
        this.data = data;
    }
}
