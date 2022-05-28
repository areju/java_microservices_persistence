package com.arjun.datapersistence.domainmodel;

public class User {
	
	/* Always better to send new copies of objects is a good practice.
	 * Because of hibernate dirty check will create unnecessary updates
	 */
	
	public String getUserName() {
		return new String(userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;
	

}
