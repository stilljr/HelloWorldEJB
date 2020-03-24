package com.cgi;

import javax.ejb.Remote;

@Remote
public interface CGISessionBeanRemote {
	public String cgiSessionBeanMethod();
}
