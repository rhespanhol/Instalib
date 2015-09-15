package me.rhespanhol.instalib.enums;

/**
 * Created by rhespanhol on 14/09/15.
 */
public enum MediaType implements InstagramEnum {

    VIDEO("video"),

    IMAGE("image");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
