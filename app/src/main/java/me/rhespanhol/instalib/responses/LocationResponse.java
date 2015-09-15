package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import me.rhespanhol.instalib.entities.Location;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class LocationResponse extends BaseResponse {

    @SerializedName("data")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
