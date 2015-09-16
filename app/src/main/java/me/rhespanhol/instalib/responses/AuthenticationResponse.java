package me.rhespanhol.instalib.responses;

import me.rhespanhol.instalib.entities.BasicUser;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class AuthenticationResponse {

    private String accessToken;

    private BasicUser user;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public BasicUser getUser() {
        return user;
    }

    public void setUser(BasicUser user) {
        this.user = user;
    }
}
