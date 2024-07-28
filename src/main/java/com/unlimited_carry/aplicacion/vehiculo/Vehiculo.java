package com.unlimited_carry.aplicacion.vehiculo;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

@Entity
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank
	private String brand; // Marca

	@Column
	@NotBlank
	private String model; // Modelo

	@Column
	@NotBlank
	@Size(min = 5, max = 8, message = "La placa debe tener entre 5 y 8 caracteres")
	private String plate; // Placa

	@Column
	@NotNull
	@Min(value = 0, message = "La capacidad de carga debe ser mayor o igual a cero")
	private Double cargoCapacity; // Cambiado a tipo Double
	@Column
	@NotBlank(groups = Optional.class)
	private String photo;

	@Column
	@NotNull(message = "El estado del vehículo no puede ser nulo")
	private boolean estado;
	

	public Vehiculo() {

	}

	public Vehiculo(String brand, String model, String plate, double cargoCapacity, String photo, boolean estado) {
		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.cargoCapacity = cargoCapacity;
		this.photo = photo;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public double getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(double cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Vehiculo{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", plate='" + plate
				+ '\'' + ", cargoCapacity=" + cargoCapacity + ", photo='" + photo + '\'' + ", estado=" + estado + '}';
	}

}