/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Model.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Keroles Magdy
 */
@Entity
@Table(name="uploaded_image"
    ,catalog="pharmacy"
)
public class UploadedImage implements Serializable{
    
    private Integer imageId;
     private String imagePath;

    public UploadedImage() {
    }

    public UploadedImage(Integer imageId, String imagePath) {
        this.imageId = imageId;
        this.imagePath = imagePath;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="IMAGE_ID", unique=true, nullable=false)
    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Column(name="IMAGE_PATH", nullable=false)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
     
     
}
