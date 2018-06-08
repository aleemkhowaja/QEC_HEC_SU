package com.qec.enums;

public enum Locality {
	

	National("National"), International("International"), HEC("HEC");
	
	 private final String locality;
	 
	 Locality(String locality) 
	 { 
		 this.locality = locality; 
	 }
	  
	 public String getValue() 
	 { 
		 return locality; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param title
	  * @return
	  */
	 public static String getValue(String locality) 
	 { 
		 if(locality.equals(National.toString()))
		 {
			 return National.getValue();
		 }
		 else if(locality.equals(International.toString()))
		 {
			 return International.getValue();
		 }
		 else if(locality.equals(HEC.toString()))
		 {
			 return HEC.getValue();
		 }
		 return ""; 
	 }

}
