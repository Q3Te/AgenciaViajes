package com.masterjava.modelos;
	import java.time.LocalDate;
	import java.util.Objects;
	import com.masterjava.enums.Empresa;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.persistence.Temporal;
	import jakarta.persistence.TemporalType;
/**
* Clase Vuelo
* @author Manuel Portal
* @version 4.3.3, 7 nov 2024
*/

@Entity
@Table(name="vuelos")
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "id_vuelo")
	private int idVuelo;
	
    @Enumerated(EnumType.STRING)
    private Empresa empresa;
	@Column(name = "fecha_vuelo")
	@Temporal(TemporalType.DATE)
	private LocalDate fechaVuelo; //Java y luego en SQL_Workbench a DATE
	private double precio;	
	@Column(name = "plazas_disponibles")
	private int plazasDisponibles;
	
	public Vuelo() {
		super();
	}
	
	public Vuelo(int idVuelo, Empresa empresa, LocalDate fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.empresa = empresa;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}
	
	public int getIdVuelo() {
		return idVuelo;
	}
	
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}
	
	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}
	
	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empresa, fechaVuelo, idVuelo, plazasDisponibles, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return empresa == other.empresa && Objects.equals(fechaVuelo, other.fechaVuelo) && idVuelo == other.idVuelo
				&& plazasDisponibles == other.plazasDisponibles
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", empresa=" + empresa + ", fechaVuelo=" + fechaVuelo + ", precio="+ precio + ", plazasDisponibles=" + plazasDisponibles + "]";
	}
}