package com.prakash.cargoloadmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.prakash.cargoloadmanagement.dto.CargoDto;
import com.prakash.cargoloadmanagement.entity.Cargo;
import com.prakash.cargoloadmanagement.repository.CargoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CargoServiceImpl implements CargoService {

	private final CargoRepository cargoRepository;

	@Override
	public CargoDto createCargo(CargoDto cargoDto) {

		Cargo cargo = this.dtoToEntity(cargoDto);
		Cargo createdCargo = cargoRepository.save(cargo);

		return this.entityToDto(createdCargo);
	}

	@Override
	public CargoDto updateCargo(CargoDto cargoDto, Integer cargoId) {
		Cargo cargo = cargoRepository.findById(cargoId).orElseThrow(() -> new ResourceAccessException("No info"));
		cargo.setName(cargoDto.getName());
		cargo.setDescription(cargoDto.getDescription());
		cargo.setWeight(cargoDto.getWeight());
		cargo.setVolume(cargoDto.getVolume());
		cargo.setPickupDate(cargoDto.getPickupDate());
		cargo.setDeliveryDate(cargoDto.getDeliveryDate());
		
		Cargo updatedCargo = this.cargoRepository.save(cargo);
		return this.entityToDto(updatedCargo);
	}

	@Override
	public CargoDto getCargoById(Integer cargoId) {
		Cargo cargo = this.cargoRepository.findById(cargoId).orElseThrow(() -> new ResourceAccessException("No info"));
		CargoDto cargoDto = this.entityToDto(cargo);
		return cargoDto ;
	}

	@Override
	public List<CargoDto> getAllCargo() {
		List<Cargo> cargos = cargoRepository.findAll();
		List<CargoDto> cargoDtos = cargos.stream().map(cargo -> this.entityToDto(cargo)).collect(Collectors.toList());

		return cargoDtos;
	}

	@Override
	public void deleteCargo(Integer cargoId) {
		Cargo cargo = this.cargoRepository.findById(cargoId)
				.orElseThrow(() -> new ResourceAccessException("No info"));
		this.cargoRepository.deleteById(cargoId);
	}

	public Cargo dtoToEntity(CargoDto cargoDto) {
		Cargo cargo = new Cargo();
		BeanUtils.copyProperties(cargoDto, cargo);
		return cargo;
	}

	public CargoDto entityToDto(Cargo cargo) {
		CargoDto cargoDto = new CargoDto();
		BeanUtils.copyProperties(cargo, cargoDto);
		return cargoDto;
	}
}
