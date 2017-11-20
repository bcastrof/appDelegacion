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

--tabla coches
CREATE PROCEDURE insertCoche
(
in marca varchar(25),
in modelo varchar(25),
in matricula varchar(10)
)
MODIFIES SQL DATA
BEGIN ATOMIC
INSERT INTO coches VALUES (marca, modelo, matricula);
END;

--tabla conducen

CREATE PROCEDURE insertConducen
(
in userwin varchar (15),
in matricula varchar(10),
in fechaRecogida date,
in horaRecogida timestamp,
in horaEntrega timestamp,
in motivo varchar(100)
)
MODIFIES SQL DATA
BEGIN ATOMIC
INSERT INTO conducen VALUES(userwin, matricula, fechaRecogida, horaRecogida, horaEntrega, motivo);
END;