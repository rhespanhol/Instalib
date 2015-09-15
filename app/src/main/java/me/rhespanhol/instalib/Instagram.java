package me.rhespanhol.instalib;

import com.google.gson.GsonBuilder;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;

import me.rhespanhol.instalib.services.MediaEndpoint;
import me.rhespanhol.instalib.services.UsersEndpoint;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by rhespanhol on 09/09/15.
 */
public class Instagram {

    public static final String SITE_URL = "https://api.instagram.com";

    public static final String OAUTH2_AUTHORIZATION_URL = SITE_URL + "/oauth/authorize/";
    public static final String OAUTH2_TOKEN_URL = SITE_URL + "/oauth/access_token";

    public static final String API_URL = "https://api.instagram.com/v1/";


    /**
     * Build an OAuth 2.0 authorization request to obtain an authorization code.
     * <p/>
     * <p>Send the user to the location URI of this request. Once the user authorized your app, the server will redirect
     * to {@code redirectUri} with the authorization code and the sent state in the query parameter {@code code}.
     * <p/>
     *
     * @param clientId    The OAuth client id obtained from trakt.
     * @param redirectUri The URI as configured on trakt to redirect to with appended auth code and state query
     *                    parameters.
     */
    public static OAuthClientRequest getAuthorizationRequest(String clientId, String redirectUri) throws OAuthSystemException {
        OAuthClientRequest.AuthenticationRequestBuilder builder = OAuthClientRequest
                .authorizationLocation(OAUTH2_AUTHORIZATION_URL)
                .setResponseType(ResponseType.CODE.toString())
                .setClientId(clientId)
                .setRedirectURI(redirectUri);
        return builder.buildQueryMessage();
    }


    /**
     * Build an OAuth 2.0 access token request. The grant is based on an authorization code that was just obtained from
     * an authorization request.
     *
     * @param clientId The OAuth client id obtained from trakt.
     * @param clientSecret The OAuth client secret obtained from trakt.
     * @param redirectUri The redirect URI as configured on trakt.
     * @param authCode A just obtained authorization code.
     */
    public static OAuthClientRequest getAccessTokenRequest(String clientId, String clientSecret, String redirectUri,
                                                           String authCode) throws OAuthSystemException {
        return OAuthClientRequest
                .tokenLocation(OAUTH2_TOKEN_URL)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setCode(authCode)
                .setRedirectURI(redirectUri)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .buildBodyMessage();
    }


    /**
     * Request an access token from trakt. Builds the request with {@link #getAccessTokenRequest} and executes it, then
     * returns the response which includes the access token.
     *
     * <p>Supply the received access token to {@link #setAccessToken(String)} and store the refresh token to later
     * refresh the access token once it has expired.
     *
     * <p>On failure re-authorization of your app is required (see {@link #getAuthorizationRequest}).
     *  @param clientId The OAuth client id obtained from trakt.
     * @param clientSecret The OAuth client secret obtained from trakt.
     * @param redirectUri The redirect URI as configured on trakt.
     * @param authCode A valid authorization code (see {@link #getAuthorizationRequest(String, String, String, String)}).
     */
    public static OAuthJSONAccessTokenResponse getAccessToken(String clientId, String clientSecret, String redirectUri,
                                                              String authCode) throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest request = getAccessTokenRequest(clientId, clientSecret, redirectUri, authCode);

        OAuthClient client = new OAuthClient(new InstagramHttpClient());
        return client.accessToken(request);
    }


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
     * @param accessToken A valid access token, obtained via e.g. {@link #getAccessToken(String, String, String,
     * String)}.
     * @return This class, to enable the builder pattern.
     */
    public Instagram setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
        mRetrofit = null;
        return this;
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
            builder.baseUrl(API_URL);
            builder.addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));

            mRetrofit = builder.build();
        }

        return mRetrofit;
    }

    private GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder;
    }

    public UsersEndpoint users() {
        return getRestAdapter().create(UsersEndpoint.class);
    }

    public MediaEndpoint media(){
        return getRestAdapter().create(MediaEndpoint.class);
    }

}
