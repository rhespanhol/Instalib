package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import me.rhespanhol.instalib.entities.Popular;
import me.rhespanhol.instalib.entities.SearchMedia;
import me.rhespanhol.instalib.responses.MediaResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class MediaService {

    public interface MediaEndpoint {

        @GET(EndpointConstants.MEDIA_ENDPOINT + "{media_id}")
        Call<MediaResponse> getMedia(
                @Path("media_id") String mediaId,
                @Query("access_token") String accessToken
        );

        @GET(EndpointConstants.MEDIA_ENDPOINT + "shortcode/{shortcode}")
        Call<MediaResponse> getMediaByShortcode(
                @Path("shortcode") String shortCode,
                @Query("access_token") String accessToken
        );

        @GET(EndpointConstants.MEDIA_ENDPOINT + "search")
        Call<SearchMedia> search(
                @Query("access_token") String accessToken,
                @Query("distance") Integer distance,
                @Query("lat") Double latitude,
                @Query("lng") Double longitude,
                @Query("min_timestamp") Long minTimestamp,
                @Query("max_timestamp") Long maxTimestamp);

        @GET(EndpointConstants.MEDIA_ENDPOINT + "popular")
        Call<Popular> getPopular(
                @Query("access_token") String accessToken
        );


    }

    Retrofit mRetrofit;
    String mAccessToken;

    MediaEndpoint mMediaEndpoint;

    public MediaService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mMediaEndpoint = mRetrofit.create(MediaEndpoint.class);
    }

    public Call<MediaResponse> getMedia(@NonNull String mediaId){
        return mMediaEndpoint.getMedia(mediaId, mAccessToken);
    }

    public Call<MediaResponse> getMediaByShortcode(@NonNull String shortcode){
        return mMediaEndpoint.getMediaByShortcode(shortcode, mAccessToken);
    }

    public Call<Popular> getPopular(){
        return mMediaEndpoint.getPopular(mAccessToken);
    }

    public Call<SearchMedia> searchByCoordinates(@NonNull Double latitude, @NonNull Double longitude, @Nullable Integer distance){
        return mMediaEndpoint.search(mAccessToken, distance, latitude, longitude, null, null);
    }

    public Call<SearchMedia> searchByTimestamp(Long minTimestamp, Long maxTimestamp){
        return mMediaEndpoint.search(mAccessToken, null, null, null, minTimestamp, maxTimestamp);
    }

    public Call<SearchMedia> search(@NonNull Double latitude, @NonNull Double longitude, @Nullable Integer distance, Long minTimestamp, Long maxTimestamp){
        return mMediaEndpoint.search(mAccessToken, distance, latitude, longitude, minTimestamp, maxTimestamp);
    }



}
