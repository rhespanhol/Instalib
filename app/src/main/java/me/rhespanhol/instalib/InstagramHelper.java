package me.rhespanhol.instalib;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;

/**
 * Created by rhespanhol on 16/09/15.
 */
public class InstagramHelper {


    /**
     * Build an OAuth 2.0 authorization request to obtain an authorization code.
     * <p/>
     * <p>Send the user to the location URI of this request. Once the user authorized your app, the server will redirect
     * to {@code redirectUri} with the authorization code and the sent state in the query parameter {@code code}.
     * <p/>
     *
     * @param clientId    The OAuth client id obtained from instagram.
     * @param redirectUri The URI as configured on instagram to redirect to with appended auth code and state query
     *                    parameters.
     */
    public static class InstagramOauthUrlBuilder {

        private final String mOauthUrl;
        private final String mClientId;
        private final String mRedirectUri;
        private String mScope;

        public InstagramOauthUrlBuilder(String clientId, String redirectUri) {
            this.mOauthUrl = InstagramConstants.OAUTH2_AUTHORIZATION_URL;
            this.mClientId = clientId;
            this.mRedirectUri = redirectUri;

        }

        public InstagramOauthUrlBuilder scope(String scope){
            this.mScope = scope;
            return this;
        }


        public String build(){
            if(mScope == null) {
                return String.format("%s?client_id=%s&redirect_uri=%s&response_type=code", mOauthUrl, mClientId, mRedirectUri);
            }

            return String.format("%s?client_id=%s&redirect_uri=%s&response_type=code&scope=%s", mOauthUrl, mClientId, mRedirectUri, mScope);

        }


    }


    /**
     * Build an OAuth 2.0 authorization request to obtain an authorization code.
     * <p/>
     * <p>Send the user to the location URI of this request. Once the user authorized your app, the server will redirect
     * to {@code redirectUri} with the authorization code and the sent state in the query parameter {@code code}.
     * <p/>
     *
     * @param clientId    The OAuth client id obtained from instagram.
     * @param redirectUri The URI as configured on instagram to redirect to with appended auth code and state query
     *                    parameters.
     */
    public static OAuthClientRequest getAuthorizationRequest(String clientId, String redirectUri) throws OAuthSystemException {
        OAuthClientRequest.AuthenticationRequestBuilder builder = OAuthClientRequest
                .authorizationLocation(InstagramConstants.OAUTH2_AUTHORIZATION_URL)
                .setResponseType(ResponseType.CODE.toString())
                .setClientId(clientId)
                .setRedirectURI(redirectUri);
        return builder.buildQueryMessage();
    }


    /**
     * Build an OAuth 2.0 access token request. The grant is based on an authorization code that was just obtained from
     * an authorization request.
     *
     * @param clientId The OAuth client id obtained from instagram.
     * @param clientSecret The OAuth client secret obtained from instagram.
     * @param redirectUri The redirect URI as configured on instagram.
     * @param authCode A just obtained authorization code.
     */
    public static OAuthClientRequest getAccessTokenRequest(String clientId, String clientSecret, String redirectUri,
                                                           String authCode) throws OAuthSystemException {
        return OAuthClientRequest
                .tokenLocation(InstagramConstants.OAUTH2_TOKEN_URL)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setCode(authCode)
                .setRedirectURI(redirectUri)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .buildBodyMessage();
    }


    /**
     * Request an access token from instagram. Builds the request with {@link #getAccessTokenRequest} and executes it, then
     * returns the response which includes the access token.
     *
     * <p>Supply the received access token to {@link #setAccessToken(String)} and store the refresh token to later
     * refresh the access token once it has expired.
     *
     * <p>On failure re-authorization of your app is required (see {@link #getAuthorizationRequest}).
     *  @param clientId The OAuth client id obtained from instagram.
     * @param clientSecret The OAuth client secret obtained from instagram.
     * @param redirectUri The redirect URI as configured on instagram.
     * @param authCode A valid authorization code (see {@link #getAuthorizationRequest(String, String)}).
     */
    public static OAuthJSONAccessTokenResponse getAccessToken(String clientId, String clientSecret, String redirectUri,
                                                              String authCode) throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest request = getAccessTokenRequest(clientId, clientSecret, redirectUri, authCode);

        OAuthClient client = new OAuthClient(new InstagramHttpClient());
        return client.accessToken(request);
    }

}
