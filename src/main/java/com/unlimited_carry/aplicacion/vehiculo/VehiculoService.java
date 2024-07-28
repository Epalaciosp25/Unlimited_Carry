package com.unlimited_carry.aplicacion.vehiculo;

import java.util.List;

public interface VehiculoService {
	void saveVehiculo(Vehiculo vehiculo);

	List<Vehiculo> getAllVehiculos();

}
