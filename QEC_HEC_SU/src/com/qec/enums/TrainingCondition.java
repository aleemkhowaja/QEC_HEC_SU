package com.qec.enums;

public enum TrainingCondition {
	

	Organized("Organized"), Attended("Attended");
	
	 private final String trainingCondition;
	 
	 TrainingCondition(String trainingCondition) 
	 { 
		 this.trainingCondition = trainingCondition; 
	 }
	  
	 public String getValue() 
	 { 
		 return trainingCondition; 
	 }
	 
	 /**
	  * get value of enum as per argument which passed from service
	  * @param title
	  * @return
	  */
	 public static String getValue(String trainingCondition) 
	 { 
		 if(trainingCondition.equals(Organized.toString()))
		 {
			 return Organized.getValue();
		 }
		 else if(trainingCondition.equals(Attended.toString()))
		 {
			 return Attended.getValue();
		 }
		 return ""; 
	 }

}
