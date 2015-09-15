package me.rhespanhol.instalib.services;

import me.rhespanhol.instalib.entities.BasicComments;
import me.rhespanhol.instalib.responses.BaseResponse;
import retrofit.Call;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 14/09/15.
 */
public interface CommentsEndpoint {

    @GET(EndpointConstants.COMMENTS_ENDPOINT)
    Call<BasicComments> getComments(
            @Path("media_id") String mediaId,
            @Query("access_token") String accessToken
    );

    @FormUrlEncoded
    @POST(EndpointConstants.COMMENTS_ENDPOINT)
    Call<BasicComments> postComment(
            @Path("media_id") String mediaId,
            @Field("text") String text,
            @Query("access_token") String accessToken
    );

    @DELETE(EndpointConstants.COMMENTS_ENDPOINT + "/{comment_id}")
    Call<BaseResponse> delete(
            @Path("media_id") String mediaId,
            @Path("comment_id") String commentId,
            @Query("access_token") String accessToken
    );
}
