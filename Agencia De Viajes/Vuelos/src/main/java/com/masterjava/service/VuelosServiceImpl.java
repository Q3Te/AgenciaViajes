package com.masterjava.service;
	import java.time.LocalDate;
	import java.util.List;
	import java.util.stream.Collectors;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.masterjava.modelos.Vuelo;
	import com.masterjava.repository.VuelosRepository;

@Service
public class VuelosServiceImpl implements VuelosService{

	@Autowired
	VuelosRepository repository;
	
	@Override
	public List<Vuelo> listaVuelosDisponiblesParaReservar(int plazasAReservar){  //Retorna vuelos con suficinetes plazas que le mandes a reservar
	    return repository.findAll().stream()
	            .filter(vuelo -> vuelo.getPlazasDisponibles()>=plazasAReservar)
	            .collect(Collectors.toList());
	}
	
	@Override
	public void actualizarVuelo(int idVuelo, int plazasAReservar, LocalDate fechaVuelo, double precio){
	    Vuelo vuelo = repository.findById(idVuelo).orElseThrow(null); //Busqueda de Vuelo por id
	    vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles()-plazasAReservar); //Actualizar plazas despues de modificar [plazasAReservar]
	    vuelo.setFechaVuelo(fechaVuelo); //Actualizar fecha vuelo nuevo 
	    vuelo.setPrecio(precio); //Actualizar precio 
	    repository.save(vuelo);
	}
	
	@Override
	public List<Vuelo> listaVuelosDisponibles() {
		 return repository.findAll();
	}
	
	//Método para Reservas, en actualizarVueloDeReserva
	@Override
	public void actualizarVueloReserva(int idVuelo, int plazasAReservar){
	    Vuelo vuelo = repository.findById(idVuelo).orElseThrow(null); //Busqueda de Vuelo por id
	    vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles()-plazasAReservar); //Actualizar plazas despues de modificar [plazasAReservar]
	    repository.save(vuelo);		
	}
}