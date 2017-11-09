--tabla usuarios

CREATE PROCEDURE borrarFuncionario
(usw varchar(15))
MODIFIES SQL DATA
BEGIN ATOMIC
DELETE FROM usuarios where userwin=usw;
END;

--tabla accesoUser

CREATE PROCEDURE borrarUsuario
(usw varchar(15))
MODIFIES SQL DATA
BEGIN ATOMIC
DELETE FROM accesoUser where userwin=usw;
END;