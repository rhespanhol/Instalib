package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class TagPagination extends Pagination {

    @SerializedName("next_max_tag_id")
    private String nextMaxTagId;

    @SerializedName("min_tag_id")
    private String minTagId;

    public String getNextMaxTagId() {
        return nextMaxTagId;
    }

    public void setNextMaxTagId(String nextMaxTagId) {
        this.nextMaxTagId = nextMaxTagId;
    }

    public String getMinTagId() {
        return minTagId;
    }

    public void setMinTagId(String minTagId) {
        this.minTagId = minTagId;
    }
}
