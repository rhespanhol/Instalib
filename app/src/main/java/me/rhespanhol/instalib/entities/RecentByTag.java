package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.MediaListResponse;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class RecentByTag extends MediaListResponse {

    private TagPagination pagination;

    public TagPagination getPagination() {
        return pagination;
    }

    public void setPagination(TagPagination pagination) {
        this.pagination = pagination;
    }

    public List<Media> getRecentByTag() {
        return data;
    }
}
