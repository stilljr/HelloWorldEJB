package com.hello;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloSessionBean
 */
@Stateless
@LocalBean
public class HelloSessionBean implements HelloSessionBeanRemote {
	
	@EJB
	private HelloSessionBeanRemote helloSessionBeanRemote;
	
	public HelloSessionBean() {
	}
	
	public HelloSessionBean(HelloSessionBeanRemote helloSessionBeanRemote) {
		this.helloSessionBeanRemote = helloSessionBeanRemote;
	}

	@Override
	public String helloSessionBeanMethod() {
		return "helloSessionBean has been Executed!!!";
	}
}
