package com.qec.enums;

public enum EmployeeTitle {
	

	Dr("Dr"), Eng("Eng"), Mr("Mr"), Mrs("Mrs"), Ms("Ms");
	
	 private final String title;
	 
	 EmployeeTitle(String title) 
	 { 
		 this.title = title; 
	 }
	  
	 public String getValue() { return title; }

}
