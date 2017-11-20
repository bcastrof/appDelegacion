--tabla usuarios

CREATE PROCEDURE moduficarFuncionario
(
usw varchar(15),
nmb varchar(50),
apds varchar(50),
crr varchar(150),
tlf integer
)
MODIFIES SQL DATA
BEGIN ATOMIC
UPDATE USUARIOS
SET nombre = nmb, apellidos = apds, correo = crr, telefono = tlf
where userwin = usw;
END;

--tabla accesoUser

CREATE PROCEDURE modificarUsuario
(
in usw varchar(15),
in psso varchar(15),
in pss varchar(15)
)
MODIFIES SQL DATA
BEGIN ATOMIC
UPDATE ACCESOUSER
SET pass = pss
WHERE userwin = usw and pass=psso;
END;

--tabla coches

CREATE PROCEDURE modificarCoche
(
in mar varchar(15),
in mde varchar(15),
in mat varchar(15) 
)
MODIFIES SQL DATA
BEGIN ATOMIC 
UPDATE COCHES
SET marca= mar, modelo=mde, matricula=mat
where matricula = mat;
END;