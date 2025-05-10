package com.noelia.proyectoFinal.entitys;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "aviones")

public class Avion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "autonomia")
    private int autonomia;

    @Column(name = "precio_hora")
    private BigDecimal precioHora;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "disponible")
    private boolean disponible;
    
    
    
    public Avion(Long id, String nombre, String modelo, String matricula, int capacidad, int autonomia,
			BigDecimal precioHora, String imagenUrl, boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.matricula = matricula;
		this.capacidad = capacidad;
		this.autonomia = autonomia;
		this.precioHora = precioHora;
		this.imagenUrl = imagenUrl;
		this.disponible = disponible;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}

	public BigDecimal getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(BigDecimal precioHora) {
		this.precioHora = precioHora;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", matricula=" + matricula
				+ ", capacidad=" + capacidad + ", autonomia=" + autonomia + ", precioHora=" + precioHora
				+ ", imagenUrl=" + imagenUrl + ", disponible=" + disponible + "]";
	}
    
    
}
