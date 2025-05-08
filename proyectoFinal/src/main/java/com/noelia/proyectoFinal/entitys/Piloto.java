package com.noelia.proyectoFinal.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "pilotos")
public class Piloto {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "experiencia_anios")
    private int experienciaAnios;

    @Column(name = "licencia")
    private String licencia;

    @Column(name = "disponible")
    private boolean disponible;
    
    public Piloto(Long id, String nombre, int experienciaAnios, String licencia, boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.experienciaAnios = experienciaAnios;
		this.licencia = licencia;
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

	public int getExperienciaAnios() {
		return experienciaAnios;
	}

	public void setExperienciaAnios(int experienciaAnios) {
		this.experienciaAnios = experienciaAnios;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nombre=" + nombre + ", experienciaAnios=" + experienciaAnios + ", licencia="
				+ licencia + ", disponible=" + disponible + "]";
	}
}