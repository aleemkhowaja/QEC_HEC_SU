package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA



/**
 * Images generated by hbm2java
 */
public class Images  implements java.io.Serializable {


     private Long imagesId;
     private Events events;
     private String imageName;
     private Long promotionId;

    public Images() {
    }

    public Images(Events events, String imageName, Long promotionId) {
       this.events = events;
       this.imageName = imageName;
       this.promotionId = promotionId;
    }
   
    public Long getImagesId() {
        return this.imagesId;
    }
    
    public void setImagesId(Long imagesId) {
        this.imagesId = imagesId;
    }
    public Events getEvents() {
        return this.events;
    }
    
    public void setEvents(Events events) {
        this.events = events;
    }
    public String getImageName() {
        return this.imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public Long getPromotionId() {
        return this.promotionId;
    }
    
    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }




}


