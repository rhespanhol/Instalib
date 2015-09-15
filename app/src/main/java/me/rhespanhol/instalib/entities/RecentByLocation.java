package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.PaginationResponse;

/**
 * Created by rhespanhol on 15/09/15.
 */
public class RecentByLocation extends PaginationResponse {

    public List<Media> getRecentByLocation(){
        return data;
    }
}
