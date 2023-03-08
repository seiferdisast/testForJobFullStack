package com.seifer.fruitshop.model;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_sequence")
    @SequenceGenerator(name="order_sequence", sequenceName="order_sequence", allocationSize=100)
    private Long id;

    @Column(length = 10000)
    private String fruitList;

    private Double fullValue;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;


    // getters and setters

    
    public String getFruitList() {
        return fruitList;
    }

    public void setFruitList(String fruitList) {
        this.fruitList = fruitList;
    }

    public Double getFullValue() {
        return fullValue;
    }

    public void setFullValue(Double fullValue) {
        this.fullValue = fullValue;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //contructor methods

    public Order(String fruitList, Double fullValue) {
        this.fruitList = fruitList;
        this.fullValue = fullValue;
    }

    //toString method

    @Override
    public String toString() {
        return "Order [id=" + id + ", fruitList=" + fruitList + ", fullValue=" + fullValue + ", creationDate="
                + creationDate + ", updateDate=" + updateDate + "]";
    }

    public Order(){}

    
}