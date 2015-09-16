package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import me.rhespanhol.instalib.entities.RecentByLocation;
import me.rhespanhol.instalib.responses.LocationResponse;
import me.rhespanhol.instalib.responses.SearchLocationResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class LocationService {

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

    Retrofit mRetrofit;
    String mAccessToken;

    LocationEndpoint mLocationEndpoint;

    public LocationService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mLocationEndpoint = mRetrofit.create(LocationEndpoint.class);
    }

    public Call<LocationResponse> getLocation(@NonNull String location){
        return mLocationEndpoint.getLocation(location, mAccessToken);
    }

    public Call<RecentByLocation> getRecent(@NonNull String locationId){
        return mLocationEndpoint.getRecent(locationId, mAccessToken, null, null, null, null);
    }

    public Call<RecentByLocation> getRecent(@NonNull String locationId, String minId, String maxId, Long minTimestamp, Long maxTimestamp){
        return mLocationEndpoint.getRecent(locationId, mAccessToken, minId, maxId, minTimestamp, maxTimestamp);
    }

    public Call<RecentByLocation> getRecentByTimestamp(@NonNull String locationId, Long minTimestamp, Long maxTimestamp){
        return mLocationEndpoint.getRecent(locationId, mAccessToken, null, null, minTimestamp, maxTimestamp);
    }

    public Call<RecentByLocation> getRecentById(@NonNull String locationId, String minId, String maxId){
        return mLocationEndpoint.getRecent(locationId, mAccessToken, minId, maxId, null, null);
    }

    public Call<SearchLocationResponse> searchByCoordinates(@NonNull Double latitude, @NonNull Double longitude, Integer distance){
        return mLocationEndpoint.search(mAccessToken, latitude, longitude, distance, null, null);
    }

    public Call<SearchLocationResponse> searchByFoursquareV1Id(@NonNull String foursquareId){
        return mLocationEndpoint.search(mAccessToken, null, null, null, null, foursquareId);
    }

    public Call<SearchLocationResponse> searchByFoursquareV2Id(@NonNull String foursquareId){
        return mLocationEndpoint.search(mAccessToken, null, null, null, foursquareId, null);
    }

    public Call<SearchLocationResponse> search(Double latitude, Double longitude, Integer distance, String foursquareV1, String foursquareV2){
        return mLocationEndpoint.search(mAccessToken, latitude, longitude, distance, foursquareV2, foursquareV1);
    }

}
