package com.qec.enums;

public enum EmployeeTitle {
	

	Dr("Dr"), Eng("Eng"), Mr("Mr"), Mrs("Mrs"), Ms("Ms");
	
	 private final String title;
	 
	 EmployeeTitle(String title) 
	 { 
		 this.title = title; 
	 }
	  
	 public String getValue() 
	 { 
		 return title; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param title
	  * @return
	  */
	 public static String getValue(String title) 
	 { 
		 if(title.equals(Mr.toString()))
		 {
			 return Mr.getValue();
		 }
		 else if(title.equals(Dr.toString()))
		 {
			 return Dr.getValue();
		 }
		 else if(title.equals(Eng.toString()))
		 {
			 return Eng.getValue();
		 }
		 else if(title.equals(Mrs.toString()))
		 {
			 return Mrs.getValue();
		 }
		 else if(title.equals(Ms.toString()))
		 {
			 return Ms.getValue();
		 }
		 
		 return ""; 
		 
	 }

}
