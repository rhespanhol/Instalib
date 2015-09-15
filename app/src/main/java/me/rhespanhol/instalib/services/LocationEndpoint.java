package me.rhespanhol.instalib.services;

import me.rhespanhol.instalib.entities.RecentByLocation;
import me.rhespanhol.instalib.responses.LocationResponse;
import me.rhespanhol.instalib.responses.SearchLocationResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 15/09/15.
 */
public interface LocationEndpoint {

    @GET(EndpointConstants.LOCATIONID_ENDPOINT)
    Call<LocationResponse> getLocation(
            @Path("location_id") String locationId,
            @Query("access_token") String accessToken);

    @GET(EndpointConstants.LOCATIONID_ENDPOINT + "/media/recent")
    Call<RecentByLocation> getRecent(
            @Path("location_id") String locationId,
            @Query("access_token") String accessToken,
            @Query("min_id") String minId,
            @Query("max_id") String maxId,
            @Query("min_timestamp") Long minTimestamp,
            @Query("max_timestamp") Long maxTimestamp);

    @GET(EndpointConstants.LOCATION_ENDPOINT + "/search")
    Call<SearchLocationResponse> search(
            @Query("access_token") String accessToken,
            @Query("lat") Double latitude,
            @Query("lng") Double longitude,
            @Query("distance") Integer distance,
            @Query("foursquare_v2_id") String foursquareV2Id,
            @Query("foursquare_id") String foursquareId);

}
