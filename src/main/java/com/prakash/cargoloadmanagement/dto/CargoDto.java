package com.prakash.cargoloadmanagement.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CargoDto {
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
