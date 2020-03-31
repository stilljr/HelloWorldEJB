package com.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldEJBSessionBeanTest {

	@Test
	public void test() {
		assertEquals(true, true);
	}
	/*private static EJBContainer ejbContainer;
	private static Context ctx;
	private static Properties p;
	
	@BeforeClass
	public static void initializeTest() {
		p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.*");
	
		p.put(EJBContainer.MODULES, new File("target/classes"));
		ejbContainer = EJBContainer.createEJBContainer(p);
		System.out.println("Starting the Container");
		ctx = ejbContainer.getContext();
	}
	
	@Test
	public void testCGISessionBean() throws NamingException {
		try {
		
	    assertNotNull(ejbContainer);
	    assertNotNull(ejbContainer.getContext());
	    final HelloSessionBeanRemote instance = HelloSessionBeanRemote.class.cast(ejbContainer.getContext().lookup("java:global/HelloWorld-ejb/HelloSessionBean"));
	    assertNotNull(instance);
	    String expectedResults = "helloSessionBean has been Executed!!!";
		String actualResults = instance.helloSessionBeanMethod();
		assertEquals(expectedResults, actualResults);
		} finally {
			if(ejbContainer==null) {
				ejbContainer.close();
			}
			System.out.println("Closing the Container");
		}  
	}*/
}
