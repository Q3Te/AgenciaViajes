CREATE DATABASE bdd_tfg_agenciadeviajes;
USE bdd_tfg_agenciadeviajes;

CREATE TABLE reservas (
  id_reserva INT AUTO_INCREMENT PRIMARY KEY,
  nombre_cliente VARCHAR(50) NULL,
  dni VARCHAR(50) NULL,
  id_hotel INT NULL,
  id_vuelo INT NULL,
  num_personas_que_forman_reserva INT NULL
);


INSERT INTO reservas (nombre_cliente, dni, id_hotel, id_vuelo,num_personas_que_forman_reserva) VALUES
  ('John Doe', '12345678A', 1, 1,23),
  ('Jane Smith', '98765432B', 2, 2,18),
  ('Bob Johnson', '11111111C', 3, 3,3),
  ('Alice Brown', '22222222D', 1, 4,1),
  ('Mike Davis', '33333333E', 2, 5,10);

  
 CREATE TABLE hoteles (
  id_hotel INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NULL,
  categoria ENUM('CINCO_ESTRELLAS','CUATRO_ESTRELLAS','TRES_ESTRELLAS','DOS_ESTRELLAS','UNA_ESTRELLA') NULL,
  precio DOUBLE NULL,
  disponible ENUM('SI','NO') NULL
);

INSERT INTO hoteles (nombre, categoria, precio, disponible) VALUES
  ('PlazaMaster', 'CINCO_ESTRELLAS', 150.00, 'SI'),
  ('CitySicel', 'CUATRO_ESTRELLAS', 100.00, 'SI'),
  ('BeachHotel', 'TRES_ESTRELLAS', 80.00, 'NO'),
  ('PalaceGarden', 'CINCO_ESTRELLAS', 200.00, 'SI'),
  ('FoxGowner', 'CUATRO_ESTRELLAS', 120.00, 'SI');

CREATE TABLE vuelos (
  id_vuelo INT AUTO_INCREMENT PRIMARY KEY,
  empresa ENUM('IBERIA','RYANAIR','VUELING','AIR_EUROPA','LUFTHANSA') NULL,
  fecha_vuelo DATE NULL,
  precio DOUBLE NULL,
  plazas_disponibles INT NULL
);

INSERT INTO vuelos (empresa, fecha_vuelo, precio, plazas_disponibles) VALUES
  ('IBERIA', DATE '2023-03-15', 200.00, 100),
  ('RYANAIR', DATE '2023-03-20', 150.00, 50),
  ('VUELING', DATE '2023-03-25', 250.00, 200),
  ('AIR_EUROPA', DATE '2023-04-01', 300.00, 150),
  ('LUFTHANSA', DATE '2023-04-05', 350.00, 250);
