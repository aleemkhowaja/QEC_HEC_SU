package com.qec.enums;

public enum Gender {
	
	Male("Male"), Female("Female"), Unspecified("Unspecified");
	
	 private final String gender;
	 
	 Gender(String gender) 
	 { 
		 this.gender = gender; 
	 }
	  
	 public String getValue() 
	 { 
		 return gender; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param gender
	  * @return
	  */
	 public static String getValue(String gender) { 
		 
		 if(gender.equals(Male.toString()))
		 {
			 return Male.getValue();
		 }
		 else if(gender.equals(Female.toString()))
		 {
			 return Female.getValue();
		 }
		 return ""; 
	 }

}
