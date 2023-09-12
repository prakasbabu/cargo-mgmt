package com.prakash.cargoloadmanagement.repository;

import com.prakash.cargoloadmanagement.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository< Cargo, Integer> {
}
