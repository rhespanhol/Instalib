package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import me.rhespanhol.instalib.entities.RecentByTag;
import me.rhespanhol.instalib.responses.SearchTagResponse;
import me.rhespanhol.instalib.responses.TagInfoResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class TagsService {

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

    Retrofit mRetrofit;
    String mAccessToken;

    TagsEndpoint mTagsEndpoint;

    public TagsService(@NonNull Retrofit retrofit, @NonNull String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mTagsEndpoint = mRetrofit.create(TagsEndpoint.class);
    }

    public Call<TagInfoResponse> getTag(@NonNull String tagName){
        return mTagsEndpoint.getTag(tagName, mAccessToken);
    }

    public Call<RecentByTag> getRecentByTag(@NonNull String tagName){
        return mTagsEndpoint.getRecent(tagName, mAccessToken, null, null);
    }

    public Call<RecentByTag> getRecentByTag(@NonNull String tagName, String minId, String maxId){
        return mTagsEndpoint.getRecent(tagName, mAccessToken, minId, maxId);
    }

    public Call<SearchTagResponse> search(@NonNull String tagName){
        return mTagsEndpoint.search(mAccessToken, tagName);
    }


}
