
insert into pacientes (id,nombre, num_tel)
values
       (2,'Carolina', '3334739153');

insert into doctores (id, especialidad, nombre, num_tel)
values (1,'ortodoncia', 'Alma Sedano', '3311257292'),
       (2,'endodoncia', 'Esly Alamilla', '3333220222'),
       (3,'cirugia', 'Diego Galvan', '3314027131'),
       (4,'resina', 'Carolina Bañuelos', '3334739153'),
       (5,'limpieza', 'Fernando Virgen', '3329218399');
insert into citas (id,fecha, hora, doctor_id, paciente_id, estado, motivo)
values (1,'2025-06-05','04:04:00',1, 1,1,'Cambio de ligas');
 insert into historial_clinico (id, paciente_id, descripcion)
 values (1, 1, 'Extraccion de muelas del juicio'),
        (2, 2, 'Tiene un golpe en la cabeza');

insert into tratamientos (id,costo, fecha_inicio, estado_tratamiento, tipo_tratamiento, paciente_id)
values (1,13500,'2025-02-02',2,4, 1),
       (2,2200, '2025-03-03', 3, 1, 2);

insert into pagos (id, cantidad, fecha_pago, tratamiento_id, descripcion)
values (1,500,now(), 1, 'Pago efectivo');
