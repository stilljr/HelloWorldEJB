package com.hello;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.hello.HelloSessionBean;
import com.hello.HelloSessionBeanRemote;

public class HelloWorldEJBSessionBeanMockitoTest {

	private static String expectedResults;
	private static HelloSessionBeanRemote movkSessionBeanRemote;
	
    @BeforeClass
    public static void initializeTest() {
    	expectedResults = "helloSessionBean has been Executed!!!";
    	movkSessionBeanRemote = Mockito.mock(HelloSessionBeanRemote.class);
    }
	
	@Test
	 public void testPersonService() {
		Mockito.when(movkSessionBeanRemote.helloSessionBeanMethod()).thenReturn(expectedResults);
		
		HelloSessionBean cgiSessionBean = new HelloSessionBean(movkSessionBeanRemote);
		
		String actualResults = cgiSessionBean.helloSessionBeanMethod();
		
		Assert.assertEquals(expectedResults, actualResults);
	}
}
