package com.example.demo.model;

import java.util.Arrays;
import java.util.Base64;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_of_owner")
    private String nameOfOwner;

    @Column(name = "contact")
    private String contact;

    @Column(name = "state")
    private String state;

    @Column(name = "location")
    private String location;

    @Column(name = "property_to_be")
    private String propertyToBe;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "description")
    private String description;

//    @Lob
//    @Column(name = "image_file")
//    private byte[] imageFile;
//
//    @Column(name = "image_file_name")
//    private String imageFileName; 
//    public byte[] getImageFile() {
//        return imageFile;
//    }
//
//    public void setImageFile(byte[] imageFile) {
//        this.imageFile = imageFile;
//    }
//
//    public String getImageFileName() {
//        return imageFileName;
//    }
//
//    public void setImageFileName(String imageFileName) {
//        this.imageFileName = imageFileName;
//    }

    // Other getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPropertyToBe() {
        return propertyToBe;
    }

    public void setPropertyToBe(String propertyToBe) {
        this.propertyToBe = propertyToBe;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", nameOfOwner=" + nameOfOwner + ", contact=" + contact + ", state=" + state
                + ", location=" + location + ", propertyToBe=" + propertyToBe + ", cost=" + cost + ", description="
                + description + "]";
    }
}
