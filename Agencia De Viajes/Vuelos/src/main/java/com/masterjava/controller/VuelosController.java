package com.masterjava.controller;
	import java.time.LocalDate;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.masterjava.modelos.Vuelo;
	import com.masterjava.service.VuelosService;
	import io.swagger.v3.oas.annotations.tags.Tag;
/**
* Clase VuelosController
* @author Manuel Portal
* @version 4.3.3, 7 nov 2024
*/

@Tag(name = "Vuelos", description = "La API de vuelos")
@RestController
@RequestMapping("/")
//@RequestMapping("/api/vuelos")
public class VuelosController {
	@Autowired
	private VuelosService vueloService;
	
	@GetMapping(value="/listaVuelosDisponiblesParaReservar/{plazasAReservar}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelosDisponiblesParaReservar(@PathVariable int plazasAReservar) {
	    return vueloService.listaVuelosDisponiblesParaReservar(plazasAReservar);
	}
	
	// http://localhost:8000/actualizarVuelo/3/150/2024-12-12/49.80
	@PutMapping(value="/actualizarVuelo/{idVuelo}/{plazasAReservar}/{fechaVuelo}/{precio}")
	public void actualizarVuelo(@PathVariable int idVuelo, @PathVariable int plazasAReservar, @PathVariable LocalDate fechaVuelo, @PathVariable double precio) {
		vueloService.actualizarVuelo(idVuelo, plazasAReservar, fechaVuelo, precio);
	}
	
	@GetMapping(value="/listaVuelosDisponibles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelosDisponibles() {
	    return vueloService.listaVuelosDisponibles();
	}
	
	//Pertenece a Registro Reserva para actualizar plazasDisponibles en vuelo de reserva
	@PutMapping(value="/actualizarDatosVueloDepuesDeReserva/{idVuelo}/{plazasAReservar}")
	public void actualizarVuelo(@PathVariable int idVuelo, @PathVariable int plazasAReservar) {
		vueloService.actualizarVueloReserva(idVuelo, plazasAReservar);
	}  
}