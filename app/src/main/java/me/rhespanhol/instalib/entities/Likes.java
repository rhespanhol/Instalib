package me.rhespanhol.instalib.entities;

import java.util.List;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Likes {

    private int count;

    private List<BasicUser> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BasicUser> getUsers() {
        return data;
    }

    public void setUsers(List<BasicUser> data) {
        this.data = data;
    }
}
