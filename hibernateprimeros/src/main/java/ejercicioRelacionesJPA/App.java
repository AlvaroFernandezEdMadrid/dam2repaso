package ejercicioRelacionesJPA;

import java.util.List;
import java.util.Scanner;

public class App {

    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static AlumnoDAO alumnoDAO = new AlumnoDAO();
    private static GrupoDAO grupoDAO = new GrupoDAO();
    private static ModuloDAO moduloDAO = new ModuloDAO();
    private static NotaDAO notaDAO = new NotaDAO();
    private static DireccionDAO direccionDAO = new DireccionDAO();

    public static void main(String[] args) {

        // Inicializar datos de prueba
        inicializarDatos();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            mostrarMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    listarAlumnosDeUnGrupo(scanner);
                    break;

                case 2:
                    listarModulosDeAlumnosDeUnGrupo(scanner);
                    break;

                case 3:
                    eliminarAlumno(scanner);
                    break;

                case 4:
                    eliminarAlumnosDeUnGrupo(scanner);
                    break;

                case 5:
                    subirUnPuntoAModulo(scanner);
                    break;

                case 6:
                    mostrarAlumnosAprobadosDeModulo(scanner);
                    break;

                case 7:
                    running = false;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }

        scanner.close();
    }

    private static void inicializarDatos() {
        // Crear profesores
        Profesor profesor1 = Profesor.builder().dni("12345678A").nombre("Juan Pérez").especialidad("Matemáticas").build();
        Profesor profesor2 = Profesor.builder().dni("87654321B").nombre("Ana López").especialidad("Lengua").build();
        profesorDAO.save(profesor1);
        profesorDAO.save(profesor2);

        // Crear direcciones
        Direccion direccion1 = Direccion.builder().calle("Calle 1").portal("12A").poblacion("Madrid").build();
        Direccion direccion2 = Direccion.builder().calle("Calle 2").portal("34B").poblacion("Barcelona").build();
        direccionDAO.save(direccion1);
        direccionDAO.save(direccion2);

        // Crear alumnos
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

        // Crear grupos
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

        // Crear módulos
        Modulo modulo1 = Modulo.builder().nombre("Álgebra").profesor(profesor1).build();
        Modulo modulo2 = Modulo.builder().nombre("Geometría").profesor(profesor1).build();
        Modulo modulo3 = Modulo.builder().nombre("Literatura").profesor(profesor2).build();
        Modulo modulo4 = Modulo.builder().nombre("Gramática").profesor(profesor2).build();
        moduloDAO.save(modulo1);
        moduloDAO.save(modulo2);
        moduloDAO.save(modulo3);
        moduloDAO.save(modulo4);

        // Asignar los módulos a los alumnos
        alumno1.getModulos().add(modulo1);
        alumno1.getModulos().add(modulo2);
        alumno2.getModulos().add(modulo3);
        alumno2.getModulos().add(modulo4);
        alumno3.getModulos().add(modulo1);
        alumno3.getModulos().add(modulo2);
        alumno4.getModulos().add(modulo3);
        alumno4.getModulos().add(modulo4);
        alumno5.getModulos().add(modulo1);
        alumno5.getModulos().add(modulo2);
    }

    private static void mostrarMenu() {
        System.out.println("\n---- Menú ----");
        System.out.println("1. Listar alumnos de un grupo");
        System.out.println("2. Listar módulos que cursan los alumnos de un grupo");
        System.out.println("3. Eliminar alumno");
        System.out.println("4. Eliminar todos los alumnos de un grupo");
        System.out.println("5. Subir un punto a todos los alumnos de un módulo");
        System.out.println("6. Mostrar alumnos aprobados de un módulo");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void listarAlumnosDeUnGrupo(Scanner scanner) {
        // Listar todos los grupos disponibles
        List<Grupo> grupos = (List<Grupo>) grupoDAO.findAll();
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + ". " + grupos.get(i).getNombre());
        }

        System.out.print("Elija el número del grupo: ");
        int grupoIndex = scanner.nextInt() - 1;
        if (grupoIndex >= 0 && grupoIndex < grupos.size()) {
            Grupo grupo = grupos.get(grupoIndex);
            System.out.println("Alumnos del grupo " + grupo.getNombre() + ":");
            for (Alumno alumno : grupo.getAlumnos()) {
                System.out.println("- " + alumno.getNombre());
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void listarModulosDeAlumnosDeUnGrupo(Scanner scanner) {
        // Listar todos los grupos disponibles
        List<Grupo> grupos = (List<Grupo>) grupoDAO.findAll();
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + ". " + grupos.get(i).getNombre());
        }

        System.out.print("Elija el número del grupo: ");
        int grupoIndex = scanner.nextInt() - 1;
        if (grupoIndex >= 0 && grupoIndex < grupos.size()) {
            Grupo grupo = grupos.get(grupoIndex);
            System.out.println("Módulos que cursan los alumnos del grupo " + grupo.getNombre() + ":");
            for (Alumno alumno : grupo.getAlumnos()) {
                System.out.println("Alumno: " + alumno.getNombre());
                for (Modulo modulo : alumno.getModulos()) {
                    System.out.println("- " + modulo.getNombre());
                }
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void eliminarAlumno(Scanner scanner) {
        // Listar todos los alumnos disponibles
        List<Alumno> alumnos = (List<Alumno>) alumnoDAO.findAll();
        System.out.println("Alumnos disponibles:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println((i + 1) + ". " + alumnos.get(i).getNombre());
        }

        System.out.print("Elija el número del alumno a eliminar: ");
        int alumnoIndex = scanner.nextInt() - 1;
        if (alumnoIndex >= 0 && alumnoIndex < alumnos.size()) {
            Alumno alumno = alumnos.get(alumnoIndex);
            alumnoDAO.delete(alumno);
            System.out.println("Alumno " + alumno.getNombre() + " eliminado.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void eliminarAlumnosDeUnGrupo(Scanner scanner) {
        // Listar todos los grupos disponibles
        List<Grupo> grupos = (List<Grupo>) grupoDAO.findAll();
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + ". " + grupos.get(i).getNombre());
        }

        System.out.print("Elija el número del grupo del que eliminar todos los alumnos: ");
        int grupoIndex = scanner.nextInt() - 1;
        if (grupoIndex >= 0 && grupoIndex < grupos.size()) {
            Grupo grupo = grupos.get(grupoIndex);
            grupo.getAlumnos().clear();
            grupoDAO.save(grupo);
            System.out.println("Todos los alumnos del grupo " + grupo.getNombre() + " han sido eliminados.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void subirUnPuntoAModulo(Scanner scanner) {
        // Listar todos los módulos disponibles
        List<Modulo> modulos = (List<Modulo>) moduloDAO.findAll();
        System.out.println("Módulos disponibles:");
        for (int i = 0; i < modulos.size(); i++) {
            System.out.println((i + 1) + ". " + modulos.get(i).getNombre());
        }

        System.out.print("Elija el número del módulo: ");
        int moduloIndex = scanner.nextInt() - 1;
        if (moduloIndex >= 0 && moduloIndex < modulos.size()) {
            Modulo modulo = modulos.get(moduloIndex);
            for (Nota nota : notaDAO.findAll()) {
                if (nota.getModulo().equals(modulo)) {
                    int nuevaNota = Math.min(nota.getValor() + 1, 10);  // Asegurar que la nota no exceda 10
                    nota.setValor(nuevaNota);
                    notaDAO.save(nota);
                }
            }
            System.out.println("Se ha subido un punto a todos los alumnos en el módulo " + modulo.getNombre());
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void mostrarAlumnosAprobadosDeModulo(Scanner scanner) {
        // Listar todos los módulos disponibles
        List<Modulo> modulos = (List<Modulo>) moduloDAO.findAll();
        System.out.println("Módulos disponibles:");
        for (int i = 0; i < modulos.size(); i++) {
            System.out.println((i + 1) + ". " + modulos.get(i).getNombre());
        }

        System.out.print("Elija el número del módulo: ");
        int moduloIndex = scanner.nextInt() - 1;
        if (moduloIndex >= 0 && moduloIndex < modulos.size()) {
            Modulo modulo = modulos.get(moduloIndex);
            System.out.println("Alumnos aprobados en el módulo " + modulo.getNombre() + ":");
            for (Nota nota : notaDAO.findAll()) {
                if (nota.getModulo().equals(modulo) && nota.getValor() >= 5) {
                    System.out.println(nota.getAlumno().getNombre() + " - Nota: " + nota.getValor());
                }
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
