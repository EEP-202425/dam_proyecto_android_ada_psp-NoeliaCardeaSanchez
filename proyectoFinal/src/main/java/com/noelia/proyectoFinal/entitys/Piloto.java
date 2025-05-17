package com.noelia.proyectoFinal.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pilotos")
public class Piloto {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    

    @Column(name = "experiencia_anios")
    private int experienciaAnios;
    
    @OneToMany(mappedBy = "piloto")     
 private List<Avion> aviones = new ArrayList<>();

    public Piloto() {
    	
    }
    
    public Piloto(Long id, String nombre, int experienciaAnios, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.experienciaAnios = experienciaAnios;
		this.apellidos = apellidos;
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

	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", experienciaAnios="
				+ experienciaAnios + "]";
	}

	
}