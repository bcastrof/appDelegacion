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