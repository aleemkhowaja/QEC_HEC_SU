package com.qec.enums;

public enum Religion {
	
	Christian("Christian"), Hindu("Hindu") ,Muslim("Muslim");
	
	private final String religion;
	 
	Religion(String religion) 
	{ 
		this.religion = religion; 
	}
	  
	public String getValue() 
	{ 
		return religion; 
	}
	
	/**
	 * get value of enum as per argument which passed from service
	 * @param religion
	 * @return
	 */
	public static String getValue(String religion) 
	{ 
		if(religion.equals(Muslim.toString()))
		{
			return Muslim.getValue();
		}
		else 
			if(religion.equals(Christian.toString()))
		{
			return Christian.getValue();
		}
		else
			if(religion.equals(Hindu.toString()))
			{
				return Hindu.getValue();
			}
		return ""; 
	}

}
