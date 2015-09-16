package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import me.rhespanhol.instalib.responses.BaseResponse;
import me.rhespanhol.instalib.responses.LikesResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.DELETE;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class LikesService {

    public interface LikesEndpoint {

        @GET(EndpointConstants.LIKES_ENDPOINT)
        Call<LikesResponse> getLikes(
                @Path("media_id") String mediaId,
                @Query("access_token") String accessToken
        );

        @FormUrlEncoded
        @POST(EndpointConstants.LIKES_ENDPOINT)
        Call<BaseResponse> like(
                @Path("media_id") String mediaId,
                @Query("access_token") String accessToken
        );

        @DELETE(EndpointConstants.LIKES_ENDPOINT)
        Call<BaseResponse> delete(
                @Path("media_id") String mediaId,
                @Query("access_token") String accessToken
        );
    }

    Retrofit mRetrofit;
    String mAccessToken;

    LikesEndpoint mLikesEndpoint;

    public LikesService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mLikesEndpoint = mRetrofit.create(LikesEndpoint.class);
    }

    public Call<LikesResponse> getLikes(@NonNull String mediaId){
        return mLikesEndpoint.getLikes(mediaId, mAccessToken);
    }

    public Call<BaseResponse> like(@NonNull String mediaId){
        return mLikesEndpoint.like(mediaId, mAccessToken);
    }

    public Call<BaseResponse> unlike(@NonNull String mediaId){
        return mLikesEndpoint.delete(mediaId, mAccessToken);
    }

}
