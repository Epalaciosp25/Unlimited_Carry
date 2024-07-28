package com.unlimited_carry.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unlimited_carry.aplicacion.vehiculo.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
	List<Vehiculo> findByEstado(boolean estado);

}