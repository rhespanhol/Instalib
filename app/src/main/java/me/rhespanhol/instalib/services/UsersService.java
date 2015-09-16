package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import me.rhespanhol.instalib.entities.Feed;
import me.rhespanhol.instalib.entities.LikedMedia;
import me.rhespanhol.instalib.entities.Recent;
import me.rhespanhol.instalib.entities.SearchUser;
import me.rhespanhol.instalib.responses.UserResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 15/09/15.
 */
public class UsersService {

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
                @Query("count") Integer count,
                @Query("min_id") String minId,
                @Query("max_id") String maxId
        );

        @GET(EndpointConstants.USER_SELF_ENDPOINT + "/media/recent")
        Call<Recent> getSelfRecentMedia(
                @Query("access_token") String accessToken,
                @Query("count") Integer count,
                @Query("min_id") String minId,
                @Query("max_id") String maxId,
                @Query("max_timestamp") String maxTimestamp,
                @Query("min_timestamp") String minTimestamp
        );

        @GET(EndpointConstants.USERS_ENDPOINT + "/media/recent")
        Call<Recent> getRecentMedia(
                @Path("user_id") String userId,
                @Query("access_token") String accessToken,
                @Query("count") Integer count,
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

    Retrofit mRetrofit;
    String mAccessToken;

    UsersEndpoint mUsersEndpoint;

    public UsersService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        this.mRetrofit = retrofit;
        this.mAccessToken = accessToken;

        this.mUsersEndpoint = this.mRetrofit.create(UsersEndpoint.class);

    }

    public Call<UserResponse> getUser(@NonNull String userId){
        return mUsersEndpoint.getUser(userId, mAccessToken);
    }

    public Call<UserResponse> getSelfUser() {
        return mUsersEndpoint.getSelfUser(mAccessToken);
    }

    public Call<Feed> getFeed(){
        return mUsersEndpoint.getSelfFeed(mAccessToken, null, null, null);
    }

    public Call<Feed> getFeed(@NonNull int count) {
        return mUsersEndpoint.getSelfFeed(mAccessToken, count, null, null);
    }

    public Call<Feed> getFeed(String minId, String maxId){
        return mUsersEndpoint.getSelfFeed(mAccessToken, null, minId, maxId);
    }

    public Call<Feed> getFeed(int count, String minId, String maxId){
        return mUsersEndpoint.getSelfFeed(mAccessToken, count, minId, maxId);
    }

    public Call<Recent> getSelfRecentMedia(){
        return mUsersEndpoint.getSelfRecentMedia(mAccessToken, null, null, null, null, null);
    }

    public Call<Recent> getSelfRecentMedia(@NonNull Integer count){
        return mUsersEndpoint.getSelfRecentMedia(mAccessToken, count, null, null, null, null);
    }

    public Call<Recent> getSelfRecentMediaById(@Nullable Integer count, String minId, String maxId){
        return mUsersEndpoint.getSelfRecentMedia(mAccessToken, count, minId, maxId, null, null);
    }

    public Call<Recent> getSelfRecentMediaByTimestamp(@Nullable Integer count, String maxTimestamp, String minTimestamp){
        return mUsersEndpoint.getSelfRecentMedia(mAccessToken, count, null, null, maxTimestamp, minTimestamp);
    }

    public Call<Recent> getSelfRecentMedia(Integer count, String minId, String maxId, String minTimestamp, String maxTimestamp){
        return mUsersEndpoint.getSelfRecentMedia(mAccessToken, count, minId, maxId, maxTimestamp, minTimestamp);
    }

    public Call<Recent> getRecentMedia(@NonNull String userId){
        return mUsersEndpoint.getRecentMedia(userId, mAccessToken, null, null, null, null, null);
    }

    public Call<Recent> getRecentMedia(@NonNull String userId, Integer count){
        return mUsersEndpoint.getRecentMedia(userId, mAccessToken, count, null, null, null, null);
    }

    public Call<Recent> getRecentMediaById(@NonNull String userId, @Nullable Integer count, String minId, String maxId){
        return mUsersEndpoint.getRecentMedia(userId, mAccessToken, count, minId, maxId, null, null);
    }

    public Call<Recent> getRecentMediaByTimestamp(@NonNull String userId, @Nullable Integer count, String maxTimestamp, String minTimestamp){
        return mUsersEndpoint.getRecentMedia(userId, mAccessToken, count, null, null, maxTimestamp, minTimestamp);
    }

    public Call<Recent> getRecentMedia(@NonNull String userId, Integer count, String minId, String maxId, String minTimestamp, String maxTimestamp){
        return mUsersEndpoint.getRecentMedia(userId, mAccessToken, count, minId, maxId, maxTimestamp, minTimestamp);
    }

    public Call<LikedMedia> getLikedMedia(Integer count) {
        return mUsersEndpoint.getLiked(mAccessToken, count, null);
    }

    public Call<LikedMedia> getLikedMedia(Integer count, String maxLikeId){
        return mUsersEndpoint.getLiked(mAccessToken, count, maxLikeId);
    }

    public Call<SearchUser> searchUser(@NonNull String user){
        return mUsersEndpoint.search(mAccessToken, user, null);
    }

    public Call<SearchUser> searchUser(@NonNull String user, Integer count){
        return mUsersEndpoint.search(mAccessToken, user, count);
    }


}
