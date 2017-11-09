--tabla usuarios

CREATE PROCEDURE insertarFuncionario
(
userwin varchar(15),
nombre varchar(50),
apellidos varchar(50),
correo varchar(150),
telefono integer
)
MODIFIES SQL DATA
BEGIN ATOMIC
INSERT INTO USUARIOS VALUES (userwin, nombre,apellidos, correo, telefono);
END;

--tabla accesoUser 

CREATE PROCEDURE insertUser
(
userwin varchar (15),
pass varchar(25),
tipo varchar(10)
)
MODIFIES SQL DATA
BEGIN ATOMIC
INSERT INTO ACCESOUSER VALUES (userwin, pass, tipo);
END; 