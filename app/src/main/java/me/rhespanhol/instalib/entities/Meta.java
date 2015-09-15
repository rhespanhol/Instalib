package me.rhespanhol.instalib.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Meta {

    private int code;

    @SerializedName("error_type")
    private String errorType;

    @SerializedName("error_message")
    private String errorMessage;
}
