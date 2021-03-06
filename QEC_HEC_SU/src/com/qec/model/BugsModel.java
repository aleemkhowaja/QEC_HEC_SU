package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bugs generated by hbm2java
 */
@Entity
@Table(name="bugs")
public class BugsModel  implements java.io.Serializable {


     private Long bugsId;
     private UserModel userModel;
     private String detail;
     private String images;
     private Date dateof;

    public BugsModel() {
    }

    public BugsModel(UserModel userModel, String detail, String images, Date dateof) {
       this.userModel = userModel;
       this.detail = detail;
       this.images = images;
       this.dateof = dateof;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="bugs_id", unique=true, nullable=false)
    public Long getBugsId() {
        return this.bugsId;
    }
    
    public void setBugsId(Long bugsId) {
        this.bugsId = bugsId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public UserModel getUser() {
        return this.userModel;
    }
    
    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }
    
    @Column(name="detail", length=65535)
    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    @Column(name="images", length=65535)
    public String getImages() {
        return this.images;
    }
    
    public void setImages(String images) {
        this.images = images;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dateof", length=10)
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }




}


