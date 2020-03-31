package com.hello;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class HelloWorldWEBJSPTest {

	@Before
    public void initializeTest() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("http://localhost:8080/HelloWorld-web");
    }
 
    @Test
    public void testIndexJSPPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Hello from JSP");
    }
}
