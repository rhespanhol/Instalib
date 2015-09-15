package me.rhespanhol.instalib.responses;


import me.rhespanhol.instalib.entities.User;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class UserResponse extends BaseResponse {

    private User data;

    public User getUser() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
