package me.rhespanhol.instalib.services;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import me.rhespanhol.instalib.InstagramConstants;
import me.rhespanhol.instalib.responses.AuthenticationResponse;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.POST;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class AuthenticationService {

    private final Retrofit mRetrofit;
    private final AuthenticationEndpoint mAuthenticationEndpoint;

    public interface AuthenticationEndpoint {
        @POST("/oauth/access_token")
        Call<AuthenticationResponse> getAccessToken(
                @Field("client_id") String clientId,
                @Field("client_secret") String clientSecret,
                @Field("grant_type") String grantType,
                @Field("redirect_uri") String redirectUri,
                @Field("code") String code
        );
    }


    public AuthenticationService() {
        mRetrofit = createRetrofit().build();
        mAuthenticationEndpoint = mRetrofit.create(AuthenticationEndpoint.class);
    }

    private Retrofit.Builder createRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(InstagramConstants.SITE_URL);
        builder.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()));

        return builder;

    }

    public Call<AuthenticationResponse> getAccessToken(@NonNull String clientId, @NonNull String clientSecret, @NonNull String redirectUri, @NonNull String code){
        return mAuthenticationEndpoint.getAccessToken(clientId, clientSecret, InstagramConstants.OAUTH_GRANT_TYPE, redirectUri, code);
    }
}
