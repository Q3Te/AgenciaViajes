package com.masterjava.service;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.masterjava.enums.Disponible;
	import com.masterjava.modelos.Hotel;
	import com.masterjava.repository.HotelesRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelesRepository repository;
	
	@Override
	public List<Hotel> listaHotelesdisponibles() {
		return repository.findByDisponible(Disponible.SI);
	}

	@Override
	public List<Hotel> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

//	Método para Reservas existentes
	@Override
	public Integer getHotelIdByName(String nombre) {
	    return repository.findIdByNombre(nombre);
	}
	//JUnit Testing
    public boolean nombreHotelEs(Hotel hotel) {
        return "PlazaMaster".equalsIgnoreCase(hotel.getNombre());
    }

    public boolean precioHotel(Hotel hotel) {
        return hotel.getPrecio() == 150;
    }
}