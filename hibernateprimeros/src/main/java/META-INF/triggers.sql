create trigger delete_alumno before delete on Alumno for each row call "ejercicioRelacionesJPA.BorrarAlumno";
