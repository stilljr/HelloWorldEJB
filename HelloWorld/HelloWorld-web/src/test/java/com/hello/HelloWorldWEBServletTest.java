package com.hello;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldWEBServletTest {
	private static String URL;
	
	@BeforeClass
	public static void initializeTest() {
		URL = "http://localhost:8080/HelloWorld-web/HelloServlet";
	}

	@Test
	public void testCGIServlet() throws Exception {
		HttpClient client = new HttpClient();

		GetMethod method = new GetMethod(URL);

		try {
			int statusCode = client.executeMethod(method);

			assertEquals("HTTP GET failed", HttpStatus.SC_OK, statusCode);

			String response = method.getResponseBodyAsString(1000);

			assertTrue("Unexpected response body", response.contains("Hello"));
		} finally {
			method.releaseConnection();
		}  
	}
}