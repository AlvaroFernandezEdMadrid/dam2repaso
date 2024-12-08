package ejercicioRelacionesJPA;

import java.util.Optional;

public class App {

    public static void main(String[] args) {
        
        // Crear los DAOs
        ProfesorDAO profesorDAO = new ProfesorDAO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        GrupoDAO grupoDAO = new GrupoDAO();
        ModuloDAO moduloDAO = new ModuloDAO();
        NotaDAO notaDAO = new NotaDAO();
        DireccionDAO direccionDAO = new DireccionDAO();
        
        // Crear los profesores
        Profesor profesor1 = Profesor.builder().dni("12345678A").nombre("Juan Pérez").especialidad("Matemáticas").build();
        Profesor profesor2 = Profesor.builder().dni("87654321B").nombre("Ana López").especialidad("Lengua").build();
        
        profesorDAO.save(profesor1);
        profesorDAO.save(profesor2);

        // Crear direcciones para los alumnos
        Direccion direccion1 = Direccion.builder().calle("Calle 1").portal("12A").poblacion("Madrid").build();
        Direccion direccion2 = Direccion.builder().calle("Calle 2").portal("34B").poblacion("Barcelona").build();
        direccionDAO.save(direccion1);
        direccionDAO.save(direccion2);
        
        // Crear los alumnos
        Alumno alumno1 = Alumno.builder().dni("11111111C").nombre("Carlos García").direccion(direccion1).build();
        Alumno alumno2 = Alumno.builder().dni("22222222D").nombre("Marta Ruiz").direccion(direccion2).build();
        Alumno alumno3 = Alumno.builder().dni("33333333E").nombre("Pedro Fernández").direccion(direccion1).build();
        Alumno alumno4 = Alumno.builder().dni("44444444F").nombre("Laura Sánchez").direccion(direccion2).build();
        Alumno alumno5 = Alumno.builder().dni("55555555G").nombre("José Martínez").direccion(direccion1).build();
        
        alumnoDAO.save(alumno1);
        alumnoDAO.save(alumno2);
        alumnoDAO.save(alumno3);
        alumnoDAO.save(alumno4);
        alumnoDAO.save(alumno5);

        // Crear los grupos
        Grupo grupo1 = Grupo.builder().nombre("Grupo A").ubicacion("Edificio 1").tutor(profesor1).build();
        Grupo grupo2 = Grupo.builder().nombre("Grupo B").ubicacion("Edificio 2").tutor(profesor2).build();
        
        grupoDAO.save(grupo1);
        grupoDAO.save(grupo2);

        // Asociar alumnos a los grupos
        grupo1.getAlumnos().add(alumno1);
        grupo1.getAlumnos().add(alumno2);
        grupo2.getAlumnos().add(alumno3);
        grupo2.getAlumnos().add(alumno4);
        grupo2.getAlumnos().add(alumno5);

        // Crear los módulos
        Modulo modulo1 = Modulo.builder().nombre("Álgebra").profesor(profesor1).build();
        Modulo modulo2 = Modulo.builder().nombre("Geometría").profesor(profesor1).build();
        Modulo modulo3 = Modulo.builder().nombre("Literatura").profesor(profesor2).build();
        Modulo modulo4 = Modulo.builder().nombre("Gramática").profesor(profesor2).build();
        
        moduloDAO.save(modulo1);
        moduloDAO.save(modulo2);
        moduloDAO.save(modulo3);
        moduloDAO.save(modulo4);

        // Asignar los módulos a los alumnos
        Nota nota1 = Nota.builder().valor(8).alumno(alumno1).modulo(modulo1).build();
        Nota nota2 = Nota.builder().valor(7).alumno(alumno1).modulo(modulo2).build();
        Nota nota3 = Nota.builder().valor(6).alumno(alumno2).modulo(modulo3).build();
        Nota nota4 = Nota.builder().valor(9).alumno(alumno2).modulo(modulo4).build();
        Nota nota5 = Nota.builder().valor(5).alumno(alumno3).modulo(modulo1).build();
        Nota nota6 = Nota.builder().valor(4).alumno(alumno3).modulo(modulo2).build();
        Nota nota7 = Nota.builder().valor(10).alumno(alumno4).modulo(modulo3).build();
        Nota nota8 = Nota.builder().valor(6).alumno(alumno4).modulo(modulo4).build();
        Nota nota9 = Nota.builder().valor(7).alumno(alumno5).modulo(modulo1).build();
        Nota nota10 = Nota.builder().valor(5).alumno(alumno5).modulo(modulo2).build();
        
        notaDAO.save(nota1);
        notaDAO.save(nota2);
        notaDAO.save(nota3);
        notaDAO.save(nota4);
        notaDAO.save(nota5);
        notaDAO.save(nota6);
        notaDAO.save(nota7);
        notaDAO.save(nota8);
        notaDAO.save(nota9);
        notaDAO.save(nota10);

        // Operaciones solicitadas
        
        // 1. Listar los alumnos de un grupo
        System.out.println("Alumnos del Grupo A:");
        grupo1.getAlumnos().forEach(alumno -> System.out.println(alumno.getNombre()));

        // 2. Listar los distintos módulos que cursan los alumnos de un grupo
        System.out.println("\nMódulos del Grupo A:");
        for (Alumno alumno : grupo1.getAlumnos()) {
            for (Nota nota : alumno.getNotas()) {
                System.out.println(nota.getModulo().getNombre());
            }
        }

        // 3. Eliminar un alumno
        System.out.println("\nEliminando alumno 1...");
        alumnoDAO.delete(alumno1);

        // 4. Eliminar todos los alumnos de un grupo
        System.out.println("\nEliminando todos los alumnos del Grupo B...");
        grupo2.getAlumnos().forEach(alumnoDAO::delete);
        
        // 5. Subir un punto a todos los alumnos en un módulo
        System.out.println("\nSubiendo un punto a todos los alumnos en el módulo de Álgebra...");
        for (Alumno alumno : grupo1.getAlumnos()) {
            Optional<Nota> notaOpt = alumno.getNotas().stream().filter(n -> n.getModulo().getNombre().equals("Álgebra")).findFirst();
            if (notaOpt.isPresent()) {
                Nota nota = notaOpt.get();
                nota.setValor(nota.getValor() + 1);
                notaDAO.save(nota);
            }
        }

        // 6. Mostrar los alumnos aprobados de un módulo
        System.out.println("\nAlumnos aprobados en el módulo de Álgebra:");
        for (Alumno alumno : grupo1.getAlumnos()) {
            Optional<Nota> notaOpt = alumno.getNotas().stream().filter(n -> n.getModulo().getNombre().equals("Álgebra")).findFirst();
            if (notaOpt.isPresent() && notaOpt.get().getValor() >= 5) {
                System.out.println(alumno.getNombre());
            }
        }
    }
}
