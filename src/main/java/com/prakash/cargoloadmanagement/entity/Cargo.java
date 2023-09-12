package com.prakash.cargoloadmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cargoId;
    private String name;
    private String description;
    private Double weight;
    private Double volume;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date pickupDate;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date deliveryDate;

}
