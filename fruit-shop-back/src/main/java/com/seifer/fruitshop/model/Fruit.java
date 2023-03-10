package com.seifer.fruitshop.model;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fruit_sequence")
    @SequenceGenerator(name="fruit_sequence", sequenceName="fruit_sequence", allocationSize=100)
    private Long id;

    private String type;

    private Long quantity;
    
    private Double price;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;


    // getters and setters


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    


    // constructor methods

    public Fruit(String type, Long quantity, Double price, Date creationDate, Date updateDate) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    //toString method

    @Override
    public String toString() {
        return "Fruit [id=" + id + ", type=" + type + ", quantity=" + quantity + ", price=" + price + ", creationDate="
                + creationDate + ", updateDate=" + updateDate + "]";
    }

    // Better not ask me why this is here...
    public Fruit(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}