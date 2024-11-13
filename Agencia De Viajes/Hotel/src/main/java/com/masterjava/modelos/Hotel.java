package com.masterjava.modelos;
	import java.util.Objects;
	import com.masterjava.enums.Categoria;
	import com.masterjava.enums.Disponible;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
/**
* Clase Hotel
* @author Manuel Portal
* @version 4.3.3, 7 nov 2024
*/
	
@Entity
@Table(name="hoteles")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel")
	private int idHotel;
	
	private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
	private double precio;
    @Enumerated(EnumType.STRING)
    private Disponible disponible;
	
	public Hotel() {
		super();
	}
	
	public Hotel(int idHotel, String nombre, Categoria categoria, double precio, Disponible disponible) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}
	
	public int getIdHotel() {
		return idHotel;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Disponible getDisponible() {
		return disponible;
	}

	public void setDisponible(Disponible disponible) {
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, disponible, idHotel, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return categoria == other.categoria && disponible == other.disponible && idHotel == other.idHotel
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio+ ", disponible=" + disponible + "]";
	}		
}