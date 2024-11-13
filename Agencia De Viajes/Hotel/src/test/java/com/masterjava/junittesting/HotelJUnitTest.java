package com.masterjava.junittesting;
	import static org.junit.jupiter.api.Assertions.assertFalse;
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import org.junit.jupiter.api.Test;
	import com.masterjava.modelos.Hotel;
	import com.masterjava.service.HotelServiceImpl;

class HotelJUnitTest {
	private final HotelServiceImpl hotelesService = new HotelServiceImpl();

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void esHotelCincoEstrellasTest() {
		//Arrange
		Hotel hotel1 = new Hotel();
		hotel1.setNombre("PlazaMaster");
        
        Hotel hotel2 = new Hotel();
        hotel2.setNombre("ABCDE");

		//Act
        boolean resultado1 = hotelesService.nombreHotelEs(hotel1);
        boolean result2 = hotelesService.nombreHotelEs(hotel2);
        
        //Assert
        assertTrue(resultado1, "Nombre Hotel Esperado [ PlazaMaster ]");
        assertFalse(result2, "Nombre Hotel Esperado distinto a [ PlazaMaster ] para aprobar assertFalse Test");
     }
	
	@Test
	void esPrecioTest() {
	    // Arrange
        Hotel hotel1 = new Hotel();
        hotel1.setPrecio(150);
        
        Hotel hotel2 = new Hotel();
        hotel2.setPrecio(100);

        // Act
        boolean resultado1 = hotelesService.precioHotel(hotel1);
        boolean result2 = hotelesService.precioHotel(hotel2);

        // Assert
        assertTrue(resultado1, "Precio Hotel Esperado [ €150 ]");
        assertFalse(result2, "Precio Hotel Esperado distinto a €100  para aprobar assertFalse Test");
	}
	
}
