package me.rhespanhol.instalib.services;


import me.rhespanhol.instalib.entities.Feed;
import me.rhespanhol.instalib.entities.LikedMedia;
import me.rhespanhol.instalib.entities.Recent;
import me.rhespanhol.instalib.entities.SearchUser;
import me.rhespanhol.instalib.responses.UserResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 14/09/15.
 */

public interface UsersEndpoint {

    @GET(EndpointConstants.USERID_ENDPOINT)
    Call<UserResponse> getUser(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken
    );

    @GET(EndpointConstants.USER_SELF_ENDPOINT)
    Call<UserResponse> getSelfUser(
            @Query("access_token") String accessToken
    );

    @GET(EndpointConstants.USER_SELF_ENDPOINT + "/feed")
    Call<Feed> getSelfFeed(
            @Query("access_token") String accessToken,
            @Query("count") int count,
            @Query("min_id") String minId,
            @Query("max_id") String maxId
    );

    @GET(EndpointConstants.USERID_ENDPOINT + "/media/recent")
    Call<Recent> getRecentMedia(
            @Query("access_token") String accessToken,
            @Query("count") int count,
            @Query("min_id") String minId,
            @Query("max_id") String maxId,
            @Query("max_timestamp") String maxTimestamp,
            @Query("min_timestamp") String minTimestamp
    );

    @GET(EndpointConstants.USER_SELF_ENDPOINT + "/media/liked")
    Call<LikedMedia> getLiked(
            @Query("access_token") String accessToken,
            @Query("count") Integer count,
            @Query("max_like_id") String maxLikeId);

    @GET(EndpointConstants.USERS_ENDPOINT + "/search")
    Call<SearchUser> search(
            @Query("access_token") String accessToken,
            @Query("q") String query,
            @Query("count") Integer count);


}
