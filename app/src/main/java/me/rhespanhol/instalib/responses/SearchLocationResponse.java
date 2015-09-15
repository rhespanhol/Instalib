package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.rhespanhol.instalib.entities.Location;


/**
 * Created by rhespanhol on 15/09/15.
 */
public class SearchLocationResponse extends BaseResponse {

    @SerializedName("data")
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
