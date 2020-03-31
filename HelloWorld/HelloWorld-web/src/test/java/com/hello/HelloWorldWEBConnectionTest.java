package com.hello;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldWEBConnectionTest {

    private String baseUrl;

    @Before
    public void initializeTest() throws Exception
    {
        String port = "8080";
        this.baseUrl = "http://localhost:" + port + "/HelloWorld-web/HelloServlet";
    }

    @Test
    public void testConnection() throws Exception
    {
        URL url = new URL(this.baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        Assert.assertEquals(200, connection.getResponseCode());
    }
}
