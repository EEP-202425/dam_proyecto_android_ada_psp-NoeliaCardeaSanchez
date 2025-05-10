package com.noelia.proyectoFinal.entitys;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "reservas")

public class Reserva {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "estado")
    private String estado; // reservado, completado, cancelado
    
    public Reserva(Long id, Avion avion, Piloto piloto, Cliente cliente, Date fechaSalida, String destino,
			String estado) {
		super();
		this.id = id;
		this.avion = avion;
		this.piloto = piloto;
		this.cliente = cliente;
		this.fechaSalida = fechaSalida;
		this.destino = destino;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", avion=" + avion + ", piloto=" + piloto + ", cliente=" + cliente
				+ ", fechaSalida=" + fechaSalida + ", destino=" + destino + ", estado=" + estado + "]";
	}
}
