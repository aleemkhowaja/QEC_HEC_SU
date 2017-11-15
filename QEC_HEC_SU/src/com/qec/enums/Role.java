package com.qec.enums;

public enum Role {
	
	Admin("admin"), Coordinator("coordinator");
	
	 private final String role;
	 
	 Role(String role) 
	 { 
		 this.role = role; 
	 }
	  
	 public String getValue() { return role; }
	    
	    
	    

}
