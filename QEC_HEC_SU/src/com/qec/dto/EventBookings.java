package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * EventBookings generated by hbm2java
 */
public class EventBookings  implements java.io.Serializable {


     private Long id;
     private Long eventId;
     private String name;
     private String email;
     private Date dateof;
     private Byte isApproved;

    public EventBookings() {
    }

    public EventBookings(Long eventId, String name, String email, Date dateof, Byte isApproved) {
       this.eventId = eventId;
       this.name = name;
       this.email = email;
       this.dateof = dateof;
       this.isApproved = isApproved;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getEventId() {
        return this.eventId;
    }
    
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }
    public Byte getIsApproved() {
        return this.isApproved;
    }
    
    public void setIsApproved(Byte isApproved) {
        this.isApproved = isApproved;
    }




}


