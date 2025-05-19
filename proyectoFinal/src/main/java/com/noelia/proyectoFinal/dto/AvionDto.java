package com.noelia.proyectoFinal.dto;




public class AvionDto {

    private String nombre;
    

    private String modelo;

    private String matricula;
    
    public AvionDto() {
    	
    }
    
    public AvionDto(Long id, String nombre, String modelo, String matricula) {
		super();
		this.nombre = nombre;
		this.modelo = modelo;
		this.matricula = matricula;
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
	



    
    
}
