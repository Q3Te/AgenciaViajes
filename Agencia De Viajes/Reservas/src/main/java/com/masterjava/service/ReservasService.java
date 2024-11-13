package com.masterjava.service;
	import java.util.List;

import com.masterjava.modelos.Reserva;

public interface ReservasService {
	public List<Reserva> reservas();
	public void registroReserva(Reserva reserva);  
	public List<Reserva> reservasExistentes(String nombreHotel);
}
