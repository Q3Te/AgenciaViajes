package com.masterjava.repository;
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import com.masterjava.modelos.Reserva;

public interface ReservasRepository extends JpaRepository<Reserva, Integer>{	
	@Query("SELECT r FROM Reserva r WHERE r.idHotel = :idHotel")
	List<Reserva> findByHotelId(@Param("idHotel") int idHotel);
}