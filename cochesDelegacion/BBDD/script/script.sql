drop table usuarios cascade;
drop table accesoUser cascade;
drop table coches cascade;
drop table conducen cascade;
drop trigger controlHoras;

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

constraint CND_USW_FK foreign key (userwin) references usuarios(userwin) on delete set null,
constraint CND_MAT_FK foreign key (matricula) references coches(matricula) on delete set null,
constraint CND_UMFHI_PK primary key (userwin, matricula, fechaRecogida, horaRecogida),
constraint CND_FRmFE_CHK check (horaEntrega>horaRecogida)
);

--inserts de prueba

insert into usuarios values ('bcastrof','Bruno','Castro','bcastrof@loquesea.com',17782);
insert into usuarios values ('casinchu','Carmen','Chueca','casinchu@loquesea.com',17782);
insert into usuarios values ('szugadib','Sabin','Barron','szugadib@loquesea.com',17782);

insert into accesoUser values ('bcastrof','123456');
insert into accesoUser values ('casinchu','123456');
insert into accesoUser values ('szugadib','123456');

insert into coches values ('Ford', 'Fiesta', '9674-GZF');
insert into coches values ('Opel', 'Moka', '5296-HZG');
insert into coches values ('Renault', 'Clio', '0746-CYS');

insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-10-31 08:00:00','2017-10-31 15:00:00','esto es una prueba' );
insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-10-31 14:00:00','2017-10-31 16:00:00','esto es una prueba' );
insert into CONDUCEN values ('bcastrof','5296-HZG', '2017-10-31', '2017-11-01 14:59:00','2017-11-01 16:00:00','esto es una prueba' );

CREATE TRIGGER controlHoras before
insert ON conducen 
REFERENCING NEW AS newrow for each row
BEGIN Atomic
declare entrega TIMESTAMP;
set (entrega)= (select max(horaentrega) from conducen where matricula = newrow.matricula and FECHARECOGIDA = newrow.fecharecogida);
if(newrow.horaRecogida < entrega) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El coche esta ocupado a la hora que lo pretendes recoger, elige otra hora u otro coche.';
end if;
end;