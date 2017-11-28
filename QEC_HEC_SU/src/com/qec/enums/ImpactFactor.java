package com.qec.enums;

public enum ImpactFactor {
	
	ISI("ISI"), Scopus("Scopus"), GoogleImpactFactor("Google Impact Factor"), ResearchGate("ResearchGate"), JCR("JCR"),
	GlobalImpactFactor("Global impact factor"), ThomasReuter("Thomas Reuter");
	
	 private final String impactFactor;
	 
	 ImpactFactor(String impactFactor) 
	 { 
		 this.impactFactor = impactFactor; 
	 }
	  
	 public String getValue() 
	 { 
		 return impactFactor; 
	 }
	 
	/**
	 * get value of enum as per argument which passed from service
	 * @param impactFactor
	 * @return
	 */
	 public static String getValue(String impactFactor) { 
		 
		 if(impactFactor.equals(ISI.toString()))
		 {
			 return ISI.getValue();
		 }
		 else if(impactFactor.equals(Scopus.toString()))
		 {
			 return Scopus.getValue();
		 }
		 else if(impactFactor.equals(GoogleImpactFactor.toString()))
		 {
			 return GoogleImpactFactor.getValue();
		 }
		 else if(impactFactor.equals(ResearchGate.toString()))
		 {
			 return ResearchGate.getValue();
		 }
		 else if(impactFactor.equals(JCR.toString()))
		 {
			 return JCR.getValue();
		 }
		 else if(impactFactor.equals(GlobalImpactFactor.toString()))
		 {
			 return GlobalImpactFactor.getValue();
		 }
		 else if(impactFactor.equals(ThomasReuter.toString()))
		 {
			 return ThomasReuter.getValue();
		 }
		 return ""; 
	 }
}
