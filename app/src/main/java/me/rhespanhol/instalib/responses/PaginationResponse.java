package me.rhespanhol.instalib.responses;

import me.rhespanhol.instalib.entities.Pagination;

/**
 * Created by rhespanhol on 15/09/15.
 */
public class PaginationResponse extends MediaListResponse {

    protected Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
