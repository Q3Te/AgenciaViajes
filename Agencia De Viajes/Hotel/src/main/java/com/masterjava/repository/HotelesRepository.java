package com.masterjava.repository;
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import com.masterjava.enums.Disponible;
	import com.masterjava.modelos.Hotel;

public interface HotelesRepository extends JpaRepository<Hotel, Integer> {
	@Query("SELECT h from Hotel h WHERE h.nombre = :nombre")
	List<Hotel> findByNombre (@Param("nombre") String nombre);
	List<Hotel> findByDisponible(Disponible disponible);  //No String xq el disponible es Enum
	
	//Para Reservas existentes
	@Query("SELECT h.idHotel FROM Hotel h WHERE h.nombre = :nombre")
	Integer findIdByNombre(@Param("nombre") String nombre);
}