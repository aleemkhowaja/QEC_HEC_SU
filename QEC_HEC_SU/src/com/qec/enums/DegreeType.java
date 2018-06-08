package com.qec.enums;

public enum DegreeType {
	

	MS("MS"), MPhil("Mphil"), Phd("Phd");
	
	 private final String degreeType;
	 
	 DegreeType(String degreeType) 
	 { 
		 this.degreeType = degreeType; 
	 }
	  
	 public String getValue() 
	 { 
		 return degreeType; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param title
	  * @return
	  */
	 public static String getValue(String degreeType) 
	 { 
		 if(degreeType.equals(MS.toString()))
		 {
			 return MS.getValue();
		 }
		 else if(degreeType.equals(MPhil.toString()))
		 {
			 return MPhil.getValue();
		 }
		 else if(degreeType.equals(Phd.toString()))
		 {
			 return Phd.getValue();
		 }
		 
		 return ""; 
	 }

}
