package me.rhespanhol.instalib.services;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class EndpointConstants {

    /*
     * Users
     */

    public static final String USERS_ENDPOINT = "users/";
    public static final String USER_SELF_ENDPOINT = USERS_ENDPOINT + "self";
    public static final String USERID_ENDPOINT = USERS_ENDPOINT + "{user_id}";

    /*
     * Media
     */

    public static final String MEDIA_ENDPOINT = "media/";
    public static final String MEDIAID_ENDPOINT = MEDIA_ENDPOINT + "{media_id}";

    /*
     * Comments
     */

    public static final String COMMENTS_ENDPOINT = MEDIAID_ENDPOINT + "/comments";

    /*
     * Likes
     */

    public static final String LIKES_ENDPOINT = MEDIAID_ENDPOINT + "/likes";

    /*
     * Tags
     */

    public static final String TAGS_ENDPOINT = "tags/";
    public static final String TAG_NAME_ENDPOINT = "tags/{tag_name}";

    /*
     * Location
     */

    public static final String LOCATION_ENDPOINT = "locations/";
    public static final String LOCATIONID_ENDPOINT = LOCATION_ENDPOINT + "{location_id}";

}
