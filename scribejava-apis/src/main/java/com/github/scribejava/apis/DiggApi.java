package com.github.scribejava.apis;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

public class DiggApi extends DefaultApi10a {

    private static final String AUTHORIZATION_URL = "http://digg.com/oauth/authorize?oauth_token=%s";
    private static final String BASE_URL = "http://services.digg.com/oauth/";

    protected DiggApi() {
    }

    private static class InstanceHolder {
        private static final DiggApi INSTANCE = new DiggApi();
    }

    public static DiggApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return BASE_URL + "request_token";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return BASE_URL + "access_token";
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZATION_URL, requestToken.getToken());
    }

}
