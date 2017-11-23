package com.qec.enums;

public enum MaritalStatus {
	
	Single("Single"), Divorced("Divorced"), Married("Married"), Seperated("Seperated"), Widow("Widow/er") ;
	
	private final String maritalStatus;
	 
	MaritalStatus(String maritalStatus) 
	{ 
		this.maritalStatus = maritalStatus; 
	}
	  
	public String getValue() { return maritalStatus; }
	
	public static String getValue(String maritalStatus)
	{
		if(maritalStatus.equals(Single.toString()))
		{
			return Single.getValue();
		}
		else
			if(maritalStatus.equals(Divorced.toString()))
			{
				return Divorced.getValue();
			}
		else
			if(maritalStatus.equals(Married.toString()))
			{
				return Married.getValue();
			}
		else
			if(maritalStatus.equals(Seperated.toString()))
			{
				return Seperated.getValue();
			}
		else
			if(maritalStatus.equals(Widow.toString()))
			{
				return Widow.getValue();
			}
		return "";
	}

}
