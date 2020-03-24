package com.cgi;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CGISessionBean
 */
@Stateless
@Remote(CGISessionBeanRemote.class)
public class CGISessionBean implements CGISessionBeanRemote {
	public String cgiSessionBeanMethod() {
		return "cgiSessionBean has been EXECUTED...!!!";
	}
}
