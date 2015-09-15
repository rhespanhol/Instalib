package me.rhespanhol.instalib.enums;

/**
 * Created by rhespanhol on 14/09/15.
 */
public enum IncomingRelationship implements InstagramEnum {
    FOLLOWED_BY("followed_by"),

    REQUESTED_BY("requested_by"),

    BLOCKED_BY("blocked_by_you"),

    NONE("none");

    private final String value;

    IncomingRelationship(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
