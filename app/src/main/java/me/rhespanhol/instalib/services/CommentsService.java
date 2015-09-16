package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import me.rhespanhol.instalib.entities.BasicComments;
import me.rhespanhol.instalib.responses.BaseResponse;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class CommentsService {

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

    Retrofit mRetrofit;
    String mAccessToken;

    CommentsEndpoint mCommentsEndpoint;

    public CommentsService(Retrofit retrofit, String accessToken) {
        mRetrofit = retrofit;
        mAccessToken = accessToken;

        mCommentsEndpoint = mRetrofit.create(CommentsEndpoint.class);
    }


    public Call<BasicComments> getComments(@NonNull String mediaId){
        return mCommentsEndpoint.getComments(mediaId, mAccessToken);
    }

    public Call<BasicComments> setComments(@NonNull String mediaId, @NonNull String text){
        return mCommentsEndpoint.postComment(mediaId, text, mAccessToken);
    }

    public Call<BaseResponse> deleteComment(@NonNull String mediaId, @NonNull String commentId){
        return mCommentsEndpoint.delete(mediaId, commentId, mAccessToken);
    }
}
