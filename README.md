"Agencia de Viajes"
======================

A SpringBoot project that defines three microservices (Ms-Vuelos, Ms-Hoteles, Ms-Reservas) interacting with each other through a MySQL database.

"Table of Contents"
-----------------

1. [Installation](#installation)
2. [Description](#description)
3. [Functionalities](#functionalities)
4. [Usage](#usage)
5. [Contribute](#contribute)
6. [History](#history)
7. [Credits and Attributions](#credits-and-attributions)
8. [License](#license)

"Installation"
---------------

N/A

"Description"
-------------

A travel agency application based on microservices. The backend consists of three microservices that access a MySQL database: Hotel, Flights, and Reservations.

"Functionalities"
-----------------

### Servicio de Hotel

* "GET /hotelesDisponibles": Returns a list of hotels with availability.
* "GET /hotelPorNombre/{nombre}": Returns data for a specific hotel by name.

### Servicio de Vuelos

* "GET /vuelosDisponibles/{plazasRequeridas}": Returns flights with sufficient available seats for the requested quantity.
* "PUT /actualizarVuelo/{idVuelo}/{plazasReservadas}": Updates the number of available seats for a flight after making a reservation.

### Servicio de Reservas

* "POST /registroReserva": Receives a JSON object with reservation data (name, DNI, idHotel, idVuelo, total persons) and registers the reservation in the database. Updates available seats in the Flights service.
* "GET /reservasPorHotel/{nombreHotel}": Returns reservations for a hotel by using the hotel name to obtain its idHotel through the Hotel service.

"Usage"
-----

### Servicio de Hotel

* Instantiate a hotel resource using the hotel name.
* Make a GET request to obtain the list of available hotels.
* Use another GET request to obtain a hotel by its name.

### Servicio de Vuelos

* Make a GET request with the required number of seats to obtain available flights.
* Use a PUT request to update a flight with the number of reserved seats.

### Servicio de Reservas

* Make a POST request with reservation data to register and update the flight.
* Use a GET request with the hotel name to obtain associated reservations.

"Contribute"
------------

N/A

"History"
---------

* Version 0.1 (2024-11-07) - Initial release
* Version 0.2 (2024-11-08) - Completed Hotel microservice
* Version 0.3 (2024-11-08) - Completed Flights microservice
* Version 0.4 (2024-11-11) - Completed Reservations microservice
* Version 0.5 (2023-04-11) - Error correction when testing with PostMan
* Version 0.6 (2023-11-12) - JUnit tests and API Rest (Swagger) implementation
* Version 0.7 (2024-11-12) - Project completion [Agencia de viajes]
* NOTE - Ports --> 7000(H), 8000(V), 8080(R); But can be modified as desired

"Credits and Attributions"
-------------------------

* Solo Learning Developer - Manuel Portal
* Tutor and Mentor - Isabel Ares

"License"
-------

OPEN SOURCE at the moment (But credit is always appreciated!)
