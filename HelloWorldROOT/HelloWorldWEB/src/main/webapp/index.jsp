<%@ page import="com.cgi.*" language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.*" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="java.lang.*"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="java.util.Properties"%>
<%@ page import="javax.naming.InitialContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello from JSP</title>
    </head>
    <body>
     
    <% out.print("<h1>Hello EJB from JSP</h1>"); %>
    <hr> 
    Welcome to the addition Application<br>
    Current Time is : <%=new java.util.Date()%>
    <hr>
    
    
    <%!
    public void jspInit() {
    try {
    	 CGISessionBeanRemote bean = doLookup();
         System.out.println(bean.cgiSessionBeanMethod()); // 4. Call business logic

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
    
    
    %>
    
    <%!
    private static CGISessionBeanRemote doLookup() {
        Context context = null;
        CGISessionBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            bean = (CGISessionBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    
    %>
    
    <%!
    private static String getLookupName() {
/*
The app name is the EAR name of the deployed EJB without .ear suffix.
Since we haven't deployed the application as a .ear,
the app name for us will be an empty string
*/
        String appName = "HelloWorldEAR";
 
        /* The module name is the JAR name of the deployed EJB
        without the .jar suffix.
        */
        String moduleName = "HelloWorldEJB";
 
/*AS7 allows each deployment to have an (optional) distinct name.
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName = CGISessionBean.class.getSimpleName();
 
        // Fully qualified remote interface name
        final String interfaceName = CGISessionBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" +
            distinctName    + "/" + beanName + "!" + interfaceName;
 
        return name;
    }
    
    %>
    
    <%!
    
    private static Context initialContext;
    
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
 
            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }
    
    %>
    
  
    </body>
    </html>