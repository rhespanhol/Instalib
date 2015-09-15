package me.rhespanhol.instalib.enums;

/**
 * Created by rhespanhol on 14/09/15.
 */
public enum Scope implements InstagramEnum {
    BASIC ("basic"),

    COMMENTS("comments"),

    RELATIONSHIPS("relationships"),

    LIKES("likes");

    private String value;

    Scope(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
