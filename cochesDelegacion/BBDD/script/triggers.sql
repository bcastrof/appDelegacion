CREATE TRIGGER controlHoras before
insert ON conducen 
REFERENCING NEW AS newrow for each row
BEGIN Atomic
declare entrega timestamp;
declare hoy date;
declare horaUsuario timestamp;
declare horaActual timestamp;
set (entrega)= (select max(horaentrega) from conducen where matricula = newrow.matricula and FECHARECOGIDA = newrow.fecharecogida);
set (hoy)= (today);
set (horaUsuario)=(select max(horaentrega) from conducen where FECHARECOGIDA = newrow.fecharecogida and userwin =newrow.userwin);
set (horaActual) = (sysdate);
if(newrow.horaRecogida < entrega) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El coche esta ocupado a la hora que lo pretendes recoger, elige otra hora u otro coche.';
end if;
if(newrow.fecharecogida<hoy or newrow.HORARECOGIDA<horaActual) then
SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'Fecha o hora de recogida menor que la fecha actual.';
end if;
if(newrow.horaRecogida<horaUsuario) then
SIGNAL SQLSTATE '45002' SET MESSAGE_TEXT = 'No puedes conducir dos coches a la vez.';
end if;
end;