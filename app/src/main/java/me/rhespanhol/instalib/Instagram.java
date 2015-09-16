package me.rhespanhol.instalib;

import com.google.gson.GsonBuilder;

import me.rhespanhol.instalib.services.CommentsService;
import me.rhespanhol.instalib.services.LikesService;
import me.rhespanhol.instalib.services.LocationService;
import me.rhespanhol.instalib.services.MediaService;
import me.rhespanhol.instalib.services.RelationshipsService;
import me.rhespanhol.instalib.services.TagsService;
import me.rhespanhol.instalib.services.UsersService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by rhespanhol on 09/09/15.
 */
public class Instagram {

    private String mAccessToken;
    private Retrofit mRetrofit;


    /**
     * Get a new API manager instance.
     *
     * <p> Re-use this instance instead of calling this constructor again.
     */
    public Instagram() {
    }

    /**
     * Sets the OAuth 2.0 access token to be appended to requests.
     *
     * <p> If set, some methods will return user-specific data.
     *
     * <p> Call this before creating a new service.
     *
     * @return This class, to enable the builder pattern.
     */
    public Instagram setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
        mRetrofit = null;
        return this;
    }

    /**
     * is the access token set? do we have a valid login?
     *
     * @return true/false
     */
    public boolean isTokenSet() {
        return this.mAccessToken != null && this.mAccessToken.length() > 0;
    }


    /**
     * Create a new {@link Retrofit.Builder}. Override this to e.g. set your own client or executor.
     *
     * @return A {@link Retrofit.Builder} with no modifications.
     */
    protected Retrofit.Builder newRestAdapterBuilder() {
        return new Retrofit.Builder();
    }

    /**
     * Return the current {@link Retrofit} instance. If none exists (first call, API key changed), builds a
     * new one.
     *
     */
    protected Retrofit getRestAdapter() {

        if (mRetrofit == null) {
            Retrofit.Builder builder = newRestAdapterBuilder();
            builder.baseUrl(InstagramConstants.API_URL);
            builder.addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));

            mRetrofit = builder.build();
        }

        return mRetrofit;
    }

    private GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder;
    }

    public CommentsService comments(){
        return new CommentsService(getRestAdapter(), mAccessToken);
    }

    public LikesService likes(){
        return new LikesService(getRestAdapter(), mAccessToken);
    }

    public LocationService location(){
        return new LocationService(getRestAdapter(), mAccessToken);
    }

    public MediaService media(){
        return new MediaService(getRestAdapter(), mAccessToken);
    }

    public RelationshipsService relationships(){
        return new RelationshipsService(getRestAdapter(), mAccessToken);
    }

    public TagsService tags(){
        return new TagsService(getRestAdapter(), mAccessToken);
    }

    public UsersService users() {
        return new UsersService(getRestAdapter(), mAccessToken);
    }

}
