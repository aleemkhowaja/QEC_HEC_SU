package com.qec.enums;

public enum HECRecognize {
	

	X("X"), Y("Y"), Z("Z"), NA("N/A");
	
	 private final String hecRecognize;
	 
	 HECRecognize(String hecRecognize) 
	 { 
		 this.hecRecognize = hecRecognize; 
	 }
	  
	 public String getValue() 
	 { 
		 return hecRecognize; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param title
	  * @return
	  */
	 public static String getValue(String hecRecognize) 
	 { 
		 if(hecRecognize.equals(X.toString()))
		 {
			 return X.getValue();
		 }
		 else if(hecRecognize.equals(Y.toString()))
		 {
			 return Y.getValue();
		 }
		 else if(hecRecognize.equals(Z.toString()))
		 {
			 return Z.getValue();
		 }
		 else if(hecRecognize.equals(NA.toString()))
		 {
			 return NA.getValue();
		 }
		 return ""; 
		 
	 }

}
