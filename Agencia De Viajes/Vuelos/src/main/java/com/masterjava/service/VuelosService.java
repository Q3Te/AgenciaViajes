package com.masterjava.service;
	import java.time.LocalDate;
	import java.util.List;
	import com.masterjava.modelos.Vuelo;

public interface VuelosService {
	public List<Vuelo> listaVuelosDisponiblesParaReservar(int plazasAReservar);
	public void actualizarVuelo(int idVuelo, int plazasAReservar,  LocalDate fechaVuelo, double precio); //La pregunta dice solo 2 parametros de URL pero me resulto más facil ponder 4 
	public List<Vuelo> listaVuelosDisponibles();
	
	//Para Reservas, en actualizarVueloDeReserva
	public void actualizarVueloReserva(int idVuelo, int plazasAReservar);
}