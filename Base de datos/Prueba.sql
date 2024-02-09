
SELECT Nombre, Apellido FROM alumnos WHERE dni in (SELECT DNI  FROM matriculaciones WHERE Curso = 3) ORDER BY nombre desc;
