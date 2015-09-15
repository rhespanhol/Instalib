package me.rhespanhol.instalib.enums;

/**
 * Created by rhespanhol on 14/09/15.
 */
public enum OutgoingRelationship implements InstagramEnum {
    FOLLOWS("follows"),

    REQUESTED("requested"),

    NONE("none");

    private final String value;

    OutgoingRelationship(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
