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
usw varchar(15),
pss varchar(15)
)
MODIFIES SQL DATA
BEGIN ATOMIC
UPDATE ACCESOUSER
SET pass = pss
WHERE userwin = usw;
END;