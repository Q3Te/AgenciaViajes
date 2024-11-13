package com.masterjava.service;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.masterjava.modelos.Reserva;
import com.masterjava.repository.ReservasRepository;

@Service
public class ReservasServiceImpl implements ReservasService {
	@Autowired
	ReservasRepository repository;
	
	@Autowired
	RestTemplate template; //Para poder trabajar entre carpetas diferentes
	private String urlRegistroReserva1="http://localhost:8000/actualizarDatosVueloDepuesDeReserva/";
	private String urlReservasExistentes="http://localhost:7000/hoteleidpornombre/";

// 		DABA MUCHOS PROBLEMAS	
//	@Override
//	public void registroReserva(Reserva reserva){
//		repository.save(reserva);
//		template.put(urlRegistroReserva1+reserva.getIdVuelo()+"/"+reserva.getNumPersonaQueFormanReserva(), null);	 
//	}
	
	@Override
	public void registroReserva(Reserva reserva){
		repository.save(reserva);
		actualizarVueloPostReserva(reserva);
	}
	
	
	public void actualizarVueloPostReserva(Reserva reserva) {
	    String url = urlRegistroReserva1+reserva.getIdVuelo()+"/"+reserva.getNumPersonaQueFormanReserva();
	    try{
	        template.put(url, null);
	    }catch(HttpServerErrorException e){
	        System.err.println("Error al actulizar vuelo: " + e.getResponseBodyAsString());
	    }
	}

	
	@Override
	public List<Reserva> reservasExistentes(String nombreHotel){     
        int idHotel = template.getForObject(urlReservasExistentes+nombreHotel, Integer.class);    //Llama a MicroServicio de Hotel para obtener idHotel
        return repository.findByHotelId(idHotel);	//Query de JPA que retorna Datos
	}
	
	@Override
	public List<Reserva> reservas() {
		return repository.findAll();
	}
}