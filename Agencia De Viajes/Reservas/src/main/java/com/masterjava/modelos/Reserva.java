package com.masterjava.modelos;
	import java.util.Objects;

import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
/**
* Clase Reserva
* @author Manuel Portal
* @version 4.3.3, 7 nov 2024
*/
@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	private String dni;
	@Column(name = "id_hotel")
	private int idHotel;
	@Column(name = "id_vuelo")
	private int idVuelo;
	@Column(name = "num_personas_que_forman_reserva")  //Añadido al leer pregunta
	private int numPersonaQueFormanReserva;
	
	public Reserva() {
		super();
	}
	
	public Reserva(int idReserva, String nombreCliente, String dni, int idHotel, int idVuelo, int numPersonaQueFormanReserva) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.numPersonaQueFormanReserva = numPersonaQueFormanReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public int getNumPersonaQueFormanReserva() {
		return numPersonaQueFormanReserva;
	}

	public void setNumPersonaQueFormanReserva(int numPersonaQueFormanReserva) {
		this.numPersonaQueFormanReserva = numPersonaQueFormanReserva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, idHotel, idReserva, idVuelo, nombreCliente, numPersonaQueFormanReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(dni, other.dni) && idHotel == other.idHotel && idReserva == other.idReserva
				&& idVuelo == other.idVuelo && Objects.equals(nombreCliente, other.nombreCliente)
				&& numPersonaQueFormanReserva == other.numPersonaQueFormanReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", nombreCliente=" + nombreCliente + ", dni=" + dni + ", idHotel="+ idHotel + ", idVuelo=" + idVuelo + ", numPersonaQueFormanReserva=" + numPersonaQueFormanReserva + "]";
	}
}