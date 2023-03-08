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
    
    private float price;

    @CreationTimestamp
    private Date fechaCreacion;

    @UpdateTimestamp
    private Date fechaActualizacion;


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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }


    // construct

    public Fruit(String type, Long quantity, float price, Date fechaCreacion, Date fechaActualizacion) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    //toString method

    @Override
    public String toString() {
        return "Fruit [id=" + id + ", type=" + type + ", quantity=" + quantity + ", price=" + price + ", fechaCreacion="
                + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
    }


    

}