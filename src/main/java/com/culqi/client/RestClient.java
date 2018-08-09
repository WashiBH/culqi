package com.culqi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

public class RestClient{

    private static final String serverURL = "https://lookup.binlist.net/";
    @Autowired
    private HttpHeaders headers;
    @Autowired
    public RestClient() {
        headers.add("Content-Type", "application/json");
    }


    public static String getServerURL() {
        return serverURL;
    }
}