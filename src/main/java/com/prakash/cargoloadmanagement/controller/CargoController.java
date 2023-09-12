package com.prakash.cargoloadmanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prakash.cargoloadmanagement.dto.CargoDto;
import com.prakash.cargoloadmanagement.service.CargoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CargoController {

	private final CargoService cargoService;

	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/cargo-home")
	public String cargoHomePage() {
		return "cargo-home";
	}

	@GetMapping("/cargo-add")
	public String cargoHome() {
		return "cargo-add";
	}

	@PostMapping("/createCargo")
	public String createCargo(CargoDto cargoDto, Model model) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		try {
			System.out.println("till here");
			Date pickupDate = dateFormat.parse(String.valueOf(cargoDto.getPickupDate()));
			Date deliveryDate = dateFormat.parse(String.valueOf(cargoDto.getDeliveryDate()));
			cargoDto.setPickupDate(pickupDate);
			cargoDto.setDeliveryDate(deliveryDate);
			cargoDto = this.cargoService.createCargo(cargoDto);
			model.addAttribute("cargoDto", cargoDto);
			model.addAttribute("message", "Cargo Created Successfully");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@GetMapping("/cargo-view")
	public String getAllCargos(Model model) {
		List<CargoDto> cargoList = this.cargoService.getAllCargo();
		System.out.println(cargoList);
		model.addAttribute("cargoList", cargoList);
		return "cargo-list";
	}

	@GetMapping ("/cargo-edit")
	public String loadUpdateForm (@RequestParam("cargoId") Integer cargoId, Model model) {
		CargoDto cargoDto = this.cargoService.getCargoById(cargoId);
		model.addAttribute("cargoDto", cargoDto);
		System.out.println(cargoDto);
		return "cargo-edit";
	}
	
	
	@GetMapping ("/updateCargo")
	public String updateCargo (@RequestParam ("cargoId") Integer cargoId, Model model, CargoDto cargoDto ) {
		CargoDto updatedCargo = this.cargoService.updateCargo(cargoDto, cargoId);
		List<CargoDto> cargoList = this.cargoService.getAllCargo();
		model.addAttribute("cargoList", cargoList);
		return "cargo-list";
	}
	
	@GetMapping("/cargo-delete")
	public String deleteCargo (@RequestParam ("cargoId") Integer cargoId, CargoDto cargoDto, Model model) {
		this.cargoService.deleteCargo(cargoId);
		List<CargoDto> cargoList = this.cargoService.getAllCargo();
		model.addAttribute("cargoList", cargoList);
		model.addAttribute("message", "Cargo deleted successfully");
		return "cargo-list";
	}
	
	
}
