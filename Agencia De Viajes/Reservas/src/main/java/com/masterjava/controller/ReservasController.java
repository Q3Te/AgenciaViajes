package com.masterjava.controller;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.masterjava.modelos.Reserva;
	import com.masterjava.service.ReservasService;
	import io.swagger.v3.oas.annotations.tags.Tag;

/**
* Clase ReservasController
* @author Manuel Portal
* @version 4.3.3, 7 nov 2024
*/

@Tag(name = "Reservas", description = "La API de reservas")
@RestController
@RequestMapping("/")
//@RequestMapping("/api/reservas")
public class ReservasController {

	@Autowired
	private ReservasService reservasService;

    @PostMapping(value="registroReserva", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void registroReserva(@RequestBody Reserva reserva){
    	reservasService.registroReserva(reserva);
    }
    
    @GetMapping(value="reservasExistentes/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Reserva>reservasExistentes(@PathVariable String nombreHotel){
    	return reservasService.reservasExistentes(nombreHotel);
    }
    
    @GetMapping(value="mostrarReservas", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Reserva>mostrarReservas(){
    	return reservasService.reservas();
    }
}