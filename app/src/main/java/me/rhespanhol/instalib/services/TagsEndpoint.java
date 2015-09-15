package me.rhespanhol.instalib.services;

import me.rhespanhol.instalib.entities.RecentByTag;
import me.rhespanhol.instalib.responses.SearchTagResponse;
import me.rhespanhol.instalib.responses.TagInfoResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 14/09/15.
 */
public interface TagsEndpoint {

    @GET(EndpointConstants.TAG_NAME_ENDPOINT)
    Call<TagInfoResponse> getTag(
            @Path("tag_name") String tagName,
            @Query("access_token") String accessToken
    );

    @GET(EndpointConstants.TAG_NAME_ENDPOINT + "/media/recent")
    Call<RecentByTag> getRecent(
            @Path("tag_name") String tagName,
            @Query("access_token") String accessToken,
            @Query("min_id") String minId,
            @Query("max_id") String maxId
    );

    @GET(EndpointConstants.TAGS_ENDPOINT + "/search")
    Call<SearchTagResponse> search(
            @Query("access_token") String accessToken,
            @Query("q") String query);

}
