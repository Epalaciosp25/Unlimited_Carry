package com.unlimited_carry.aplicacion.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unlimited_carry.aplicacion.vehiculo.Vehiculo;
import com.unlimited_carry.aplicacion.vehiculo.VehiculoService;
import com.unlimited_carry.aplicacion.repository.VehiculoRepository;

@Transactional
@Service
public class VehiculoServiceImpl implements VehiculoService {

	private final VehiculoRepository vehiculoRepository;

	@Autowired
	public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	@Override
	public void saveVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}

	public List<Vehiculo> getAllVehiculos() {
		return vehiculoRepository.findAll();
	}
}
