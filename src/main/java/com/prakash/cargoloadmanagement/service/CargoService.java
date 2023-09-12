package com.prakash.cargoloadmanagement.service;

import com.prakash.cargoloadmanagement.dto.CargoDto;
import com.prakash.cargoloadmanagement.entity.Cargo;

import java.util.List;

public interface CargoService {

     CargoDto createCargo(CargoDto cargoDto);
    CargoDto updateCargo(CargoDto cargoDto, Integer cargoId);
    CargoDto getCargoById(Integer cargoId);
    List<CargoDto> getAllCargo();
    void deleteCargo(Integer cargoId);
}
