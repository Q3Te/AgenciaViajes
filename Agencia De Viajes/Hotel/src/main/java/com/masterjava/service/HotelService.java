package com.masterjava.service;
	import java.util.List;
	import com.masterjava.modelos.Hotel;

public interface HotelService {
	public List<Hotel> listaHotelesdisponibles();
	List<Hotel> findByNombre(String nombre); //Tambien en HotelRepository
	public Integer getHotelIdByName(String nombre);
}