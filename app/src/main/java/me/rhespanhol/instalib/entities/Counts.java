package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 10/09/15.
 */
public class Counts {

    private int media;

    private int follows;

    @SerializedName("followed_by")
    private int followedBy;
}
