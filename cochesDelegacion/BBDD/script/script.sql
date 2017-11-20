drop trigger controlHoras;
drop procedure recuperarFunci;
drop procedure recuperarFuncionarios;
drop procedure recuperarUsuario;
drop procedure recuperar_Usuario;
drop procedure insertarFuncionario;
drop procedure insertUser;
drop procedure moduficarFuncionario;
drop procedure modificarUsuario;
drop procedure borrarFuncionario;
drop procedure borrarUsuario;
drop table usuarios cascade;
drop table accesoUser cascade;
drop table coches cascade;
drop table conducen cascade;

create table usuarios
(
userwin varchar(15),
nombre varchar(50),
apellidos varchar(50),
correo varchar(150),
telefono integer,
constraint USR_USW_PK primary key (userwin)
);

create table accesoUser
(
userwin varchar (15),
pass varchar(25),
tipo varchar(10),
constraint ACC_USW_FK foreign key (userwin) references usuarios (userwin) on delete cascade,
constraint ACC_USW_PK primary key (userwin)
);

create table coches
(
marca varchar(25),
modelo varchar(25),
matricula varchar(10),
constraint CCH_MAT_PK primary key (matricula)
);

create table conducen
(
userwin varchar (15),
matricula varchar(10),
fechaRecogida date,
horaRecogida timestamp,
horaEntrega timestamp,
motivo varchar(100),

constraint CND_USW_FK foreign key (userwin) references usuarios(userwin) on delete cascade,
constraint CND_MAT_FK foreign key (matricula) references coches(matricula) on delete cascade,
constraint CND_UMFHI_PK primary key (userwin, matricula, fechaRecogida, horaRecogida) on delete cascade,
constraint CND_FRmFE_CHK check (horaEntrega>horaRecogida),
constraint CND_FER_CHK check (fechaRecogida >= TODAY);
);

--inserts de prueba

insert into usuarios values ('bcastrof','Bruno','Castro','bcastrof@loquesea.com',17782);
insert into usuarios values ('casinchu','Carmen','Chueca','casinchu@loquesea.com',17782);
insert into usuarios values ('szugadib','Sabin','Barron','szugadib@loquesea.com',17782);

insert into accesoUser values ('bcastrof','123456', 'admin');
insert into accesoUser values ('casinchu','123456', 'user');
insert into accesoUser values ('szugadib','123456', 'user');

insert into coches values ('Ford', 'Fiesta', '9674-GZF');
insert into coches values ('Opel', 'Moka', '5296-HZG');
insert into coches values ('Renault', 'Clio', '0746-CYS');

insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-10-31 08:00:00','2017-10-31 15:00:00','esto es una prueba' );
insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-10-31 14:00:00','2017-10-31 16:00:00','esto es una prueba' );
insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-11-01 14:59:00','2017-11-01 16:00:00','esto es una prueba' );

--vista carga usuarios
drop view cargausuario;

CREATE VIEW cargaUsuario
as 
(select a.USERWIN, a.PASS, a.TIPO, u.NOMBRE, u.APELLIDOS, u.CORREO, u.TELEFONO from accesouser a
join Usuarios u
on
a.USERWIN=u.USERWIN);

