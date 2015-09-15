package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.PaginationResponse;


/**
 * Created by rhespanhol on 14/09/15.
 */
public class Feed extends PaginationResponse {

    public List<Media> getFeedMedia() {
        return data;
    }
}
