package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA



/**
 * AccreditationCouncilid generated by hbm2java
 */
public class AccreditationCouncilDTO  implements java.io.Serializable {


     private Long accreditationCouncilId;
     private String name;

    public AccreditationCouncilDTO() {
    }

    public AccreditationCouncilDTO(String name) {
       this.name = name;
    }
   
    public Long getAccreditationCouncilId() {
        return this.accreditationCouncilId;
    }
    
    public void setAccreditationCouncilId(Long accreditationCouncilId) {
        this.accreditationCouncilId = accreditationCouncilId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


