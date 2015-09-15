package me.rhespanhol.instalib.enums;

/**
 * Created by rhespanhol on 14/09/15.
 */
public enum ActionRelationship implements InstagramEnum {
    FOLLOW("follow"),

    UNFOLLOW("unfollow"),

    BLOCK("block"),

    UNBLOCK("unblock"),

    APPROVE("approve"),

    DENY("deny");

    private final String value;

    ActionRelationship(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
