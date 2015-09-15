package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.PaginationResponse;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Recent extends PaginationResponse {

    public List<Media> getRecentMedia() {
        return data;
    }

    public void setData(List<Media> data) {
        this.data = data;
    }
}
