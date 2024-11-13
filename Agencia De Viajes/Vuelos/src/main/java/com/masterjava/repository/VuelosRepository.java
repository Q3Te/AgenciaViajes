package com.masterjava.repository;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import com.masterjava.modelos.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo, Integer> {
	@Query("SELECT v.idVuelo, v.plazasDisponibles FROM Vuelo v WHERE v.idVuelo = :idVuelo")
	Vuelo findByVueloId(@Param("idVuelo")int idVuelo);
}