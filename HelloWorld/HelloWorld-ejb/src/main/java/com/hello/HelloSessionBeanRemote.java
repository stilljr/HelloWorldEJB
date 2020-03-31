package com.hello;

import javax.ejb.Remote;

@Remote
public interface HelloSessionBeanRemote {
	public String helloSessionBeanMethod();
}
