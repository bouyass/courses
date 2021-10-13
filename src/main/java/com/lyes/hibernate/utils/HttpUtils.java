package com.lyes.hibernate.utils;

import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

    public void sendRequest(String address) throws IOException {
        HttpClient client = HttpClient.New(new URL(address));
    }

}
