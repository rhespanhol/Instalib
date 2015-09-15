package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.MediaListResponse;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Popular extends MediaListResponse {

    public List<Media> getPopularMediaList() {
        return data;
    }

    public void setData(List<Media> data) {
        this.data = data;
    }
}
