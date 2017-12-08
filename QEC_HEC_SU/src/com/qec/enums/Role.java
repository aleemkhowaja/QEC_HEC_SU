package com.qec.enums;

public enum Role {
	
	Admin("admin"), Coordinator("coordinator");
	
	 private final String role;
	 
	 Role(String role) 
	 { 
		 this.role = role; 
	 }
	  
	 public String getValue() 
	 { 
		 return role; 
	 }
	 
	 /**
		 * get value of enum as per argument which passed from service
		 * @param role
		 * @return
		 */
		public static String getValue(String role) 
		{ 
			if(role.equals(Admin.toString()))
			{
				return Admin.getValue();
			}
			else 
				if(role.equals(Coordinator.toString()))
			{
				return Coordinator.getValue();
			}
			return ""; 
		}

}
