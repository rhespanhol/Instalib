package me.rhespanhol.instalib;

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
}
