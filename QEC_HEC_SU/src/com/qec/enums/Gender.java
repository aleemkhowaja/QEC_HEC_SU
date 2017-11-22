package com.qec.enums;

public enum Gender {
	
	Male("Male"), Female("Female"), Unspecified("Unspecified");
	
	 private final String gender;
	 
	 Gender(String gender) 
	 { 
		 this.gender = gender; 
	 }
	  
	 public String getValue() { return gender; }

}
