package com.unlimited_carry.aplicacion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unlimited_carry.aplicacion.vehiculo.Vehiculo;
import com.unlimited_carry.aplicacion.vehiculo.VehiculoService;

@Controller
public class VehiculoController {

	private final VehiculoService vehiculoService;

	public VehiculoController(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@GetMapping("/registro-vehiculo")
	public String registroVehiculo(Model model) {
		System.out.println("GET request to /registro-vehiculo");
		model.addAttribute("vehiculoForm", new Vehiculo());
		return "registro-vehiculo";
	}

	@PostMapping("/registro-vehiculo")
	public String registroVehiculoAction(@Valid @ModelAttribute("vehiculoForm") Vehiculo vehiculo, BindingResult result,
			Model model) {
		System.out.println("Datos recibidos del formulario:");
		System.out.println("Marca: " + vehiculo.getBrand());
		System.out.println("Modelo: " + vehiculo.getModel());
		System.out.println("Placa: " + vehiculo.getPlate());
		System.out.println("Capacidad de carga: " + vehiculo.getCargoCapacity());
		System.out.println("Foto: " + vehiculo.getPhoto());
		System.out.println("Estado: " + vehiculo.isEstado());
		try {
			// Agregar logging para registrar los datos recibidos del formulario

			vehiculoService.saveVehiculo(vehiculo);

			System.out.println("Vehículo guardado exitosamente.");

			return "registro-vehiculo"; // Redirigir a una página de éxito
		} catch (Exception e) {
			System.err.println("Error al guardar el vehículo: " + e.getMessage());
			model.addAttribute("error", "Error al guardar el vehículo. Por favor, inténtalo de nuevo.");
			return "registro-vehiculo";
		}
	}

	@GetMapping("/vehiculos-registrados")
	public String vehiculosRegistrados(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			// Verifica si el usuario tiene el rol de administrador
			if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				// Lógica para mostrar la página de vehículos registrados
				return "vehiculos-registrados";
			}
		}
		// Redirige al usuario no autorizado a una página de acceso denegado
		return "acceso-denegado";
	}

	@GetMapping("/services/vehicle-availability")
	public String showVehicleAvailability(Model model) {
		List<Vehiculo> vehiculos = vehiculoService.getAllVehiculos(); // Obtener la lista de vehículos desde el servicio
		model.addAttribute("vehiculos", vehiculos); // Pasar la lista de vehículos al modelo
		return "vehicle-availability"; // Devolver el nombre de la vista
	}

	// Controlador para la página de éxito
	@GetMapping("/registro-vehiculo-exitoso")
	public String registroVehiculoExitoso() {
		return "registro-vehiculo-exitoso";
	}
}
