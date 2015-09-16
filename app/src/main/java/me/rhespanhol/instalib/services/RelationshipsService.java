package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import me.rhespanhol.instalib.entities.Followees;
import me.rhespanhol.instalib.entities.Followers;
import me.rhespanhol.instalib.entities.RequestedBy;
import me.rhespanhol.instalib.enums.ActionRelationship;
import me.rhespanhol.instalib.responses.RelationshipResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class RelationshipsService {

    public interface RelationshipsEndpoint {

        @GET(EndpointConstants.USERID_ENDPOINT + "/follows")
        Call<Followers> getFollowers(
                @Path("user_id") String userId,
                @Query("access_token") String accessToken
        );

        @GET(EndpointConstants.USERID_ENDPOINT + "/followed-by")
        Call<Followees> getFollowees(
                @Path("user_id") String userId,
                @Query("access_token") String accessToken
        );

        @GET(EndpointConstants.USER_SELF_ENDPOINT + "/requested-by")
        Call<RequestedBy> getRequestedBy(
                @Query("access_token") String accessToken);

        @GET(EndpointConstants.USERID_ENDPOINT + "/relationship")
        Call<RelationshipResponse> getRelationship(
                @Path("user_id") String userId,
                @Query("access_token") String accessToken);

        @FormUrlEncoded
        @POST(EndpointConstants.USERID_ENDPOINT + "/relationship")
        Call<RelationshipResponse> postRelationship(
                @Path("user_id") String userId,
                @Field("action") String action,
                @Query("access_token") String accessToken);


    }

    Retrofit mRetrofit;
    String mAccessToken;

    RelationshipsEndpoint mRelationshipsEndpoint;

    public RelationshipsService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mRelationshipsEndpoint = mRetrofit.create(RelationshipsEndpoint.class);
    }

    public Call<Followers> getFollowers(@NonNull String userId){
        return mRelationshipsEndpoint.getFollowers(userId, mAccessToken);
    }

    public Call<Followees> getFollowees(@NonNull String userId){
        return mRelationshipsEndpoint.getFollowees(userId, mAccessToken);
    }

    public Call<RequestedBy> getRequesters(){
        return mRelationshipsEndpoint.getRequestedBy(mAccessToken);
    }

    public Call<RelationshipResponse> getRelationship(@NonNull String userId){
        return mRelationshipsEndpoint.getRelationship(userId, mAccessToken);
    }

    public Call<RelationshipResponse> setRelationship(@NonNull String userId, @NonNull ActionRelationship actionRelationship){
        return mRelationshipsEndpoint.postRelationship(userId, actionRelationship.toString(), mAccessToken);
    }
}
