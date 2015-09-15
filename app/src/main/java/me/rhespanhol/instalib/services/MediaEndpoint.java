package me.rhespanhol.instalib.services;

import me.rhespanhol.instalib.entities.Popular;
import me.rhespanhol.instalib.entities.SearchMedia;
import me.rhespanhol.instalib.responses.MediaResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 11/09/15.
 */
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
            @Query("distance") Integer distanceInKm,
            @Query("lat") Double latitude,
            @Query("lng") Double longitude,
            @Query("min_timestamp") Long minTimestamp,
            @Query("max_timestamp") Long maxTimestamp);

    @GET(EndpointConstants.MEDIA_ENDPOINT + "popular")
    Call<Popular> getPopular(
            @Query("access_token") String accessToken
    );


}
