package com.example.LocalMarketplace.config;

public class PathConfig {

    public static final String basePathRead = "http://localhost:8090";

    public static final String gamePathIdRead = basePathRead + "/game/id/";

    public static final String gamePathNameRead = basePathRead + "/game/name/";

    public static final String platformPathIdRead = basePathRead + "/platform/id/";

    public static final String platformPathNameRead = basePathRead + "/platform/name/";

    public static final String profilePathIdRead = basePathRead + "/profile/id/";

    public static final String profilePathUsernameRead = basePathRead + "/profile/name/";

    public static final String profileUpdate = "http://localhost:8070/profile/updateFromGame";

}
