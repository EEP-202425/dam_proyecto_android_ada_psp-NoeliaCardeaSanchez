package com.noelia.proyectoFinal.entitys;

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
    
    public Avion() {
    	
    }
    
    public Avion(Long id, String nombre, String modelo, String matricula) {
		super();
		this.id = id;
		this.nombre = nombre;

		this.modelo = modelo;
		this.matricula = matricula;
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
	

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", matricula=" + matricula
				+ ", capacidad=" + "]";
	}
    
    
}
