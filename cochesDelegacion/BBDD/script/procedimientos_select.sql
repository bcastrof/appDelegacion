--tabla usuarios

CREATE PROCEDURE recuperarFunci
(
IN USW VARCHAR(15),
out nom varchar(50),
out ape varchar(50),
out crr varchar(150),
out tlf integer
)
READS SQL DATA 
BEGIN ATOMIC
SELECT nombre, apellidos, correo, telefono into 
nom,
ape,
crr,
tlf
FROM USUARIOS WHERE USERWIN = USW;
END;

CREATE PROCEDURE recuperarFuncionarios
()
READS SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE res CURSOR FOR SELECT * FROM USUARIOS;
OPEN res;
END;

--tabla accesoUsuarios

CREATE PROCEDURE recuperarUsuario
(USW VARCHAR(15), PAS VARCHAR(25))
READS SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE res CURSOR FOR SELECT * FROM ACCESOUSER WHERE USERWIN=USW AND PASS=PAS;
OPEN res;
END;


CREATE PROCEDURE recuperar_Usuario
(IN USW VARCHAR(15), IN PAS VARCHAR(15), OUT USWO VARCHAR(15), OUT TIP VARCHAR(7))
READS SQL DATA
BEGIN ATOMIC
SELECT userwin, tipo INTO USWO, TIP FROM ACCESOUSER WHERE USERWIN=USW AND PASS=PAS;
END;

--tablas accesoUsuarios + usuarios
CREATE PROCEDURE cargaUsuario
(
in uswi varchar(15),
in passi varchar (15),
out uswo varchar(15),
out tip varchar(15),
out nom varchar(15),
out apo varchar (15),
out corro varchar(15),
out tlfo integer
)
READS SQL DATA
BEGIN ATOMIC
SELECT a.USERWIN, a.TIPO, u.NOMBRE, u.APELLIDOS, u.CORREO, u.TELEFONO INTO uswo, tip, nom, apo, corro, tlfo 
from accesouser a
join Usuarios u
on
a.USERWIN=u.USERWIN
WHERE userwin = uswi AND pass = passi;
END;

--tablas accesoUsuarios + usuarios + conducen
create procedure cargaReservas
(
in fechaRi date,
out nom varchar(50),
out apo varchar(50),
out fechaR date,
out horaR timestamp,
out horaE timestamp
)
READS SQL DATA
BEGIN ATOMIC
SELECT u.nombre, u.apellidos, c.fechaRecogida, c.horaRecogida, c.horaEntrega INTO nom, apo, fechaR, horaR, horaE
from accesouser a
join usuarios u
on 
a.userwin = u.userwin
join
conducen c
on
c.userwin = a.userwin
where fechaRecogida = fechaRi;
END;

CREATE PROCEDURE cargaReservas(IN fechaRi varchar(50))
READS SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR FOR SELECT u.nombre, u.apellidos,co.MARCA, co.MODELO, c.fechaRecogida, c.horaRecogida, c.horaEntrega, c.MOTIVO
from accesouser a
join usuarios u
on 
a.userwin = u.userwin
join
conducen c
on
c.userwin = a.userwin
join coches co
on
co.MATRICULA=c.MATRICULA
where c.fechaRecogida = fechaRi;
OPEN result;
END;

CREATE PROCEDURE cargaReservas1()
READS SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR FOR SELECT a.USERWIN, u.NOMBRE, u.APELLIDOS, u.CORREO, co.MARCA, co.MODELO, co.MATRICULA, c.FECHARECOGIDA, c.HORARECOGIDA, c.HORAENTREGA, c.MOTIVO
from accesouser a
join usuarios u
on 
a.userwin = u.userwin
join
conducen c
on
c.userwin = a.userwin
join coches co
on
co.MATRICULA=c.MATRICULA;
order by c.fechaRecogida, c.horaRecogida
OPEN result;
END;

--tabla coches
create procedure cargaCoches
(
)
READS SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR FOR SELECT * from coches ORDER BY  matricula asc;
open result;
END;
