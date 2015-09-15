package me.rhespanhol.instalib.entities;

import java.util.List;

import me.rhespanhol.instalib.responses.BasicUserListResponse;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class Followees extends BasicUserListResponse {

    public List<BasicUser> getFollowees() {
        return data;
    }

    public void setData(List<BasicUser> data) {
        this.data = data;
    }
}
