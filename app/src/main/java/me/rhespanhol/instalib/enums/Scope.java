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


    public static class ScopeBuilder {
        private boolean mBasic = true;
        private boolean mComments;
        private boolean mRelationships;
        private boolean mLikes;

        public ScopeBuilder() {
        }

        public ScopeBuilder basic(){
            mBasic = true;
            return this;
        }

        public ScopeBuilder comments(){
            mComments = true;
            return this;
        }

        public ScopeBuilder relationships(){
            mRelationships = true;
            return this;
        }

        public ScopeBuilder likes(){
            mLikes = true;
            return this;
        }

        public String build(){
            return "basic";
        }
    }

}
