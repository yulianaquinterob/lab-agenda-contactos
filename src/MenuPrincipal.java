import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;

        do {
            System.out.println("**** AGENDA DE CONTACTOS ****");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Listar historial");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.print("Elige una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opcion invalida, intenta de nuevo");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("*** AGREGAR CONTACTO ***");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                }
                case 2 -> {
                    System.out.println("*** BUSCAR CONTACTO ***");
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto encontrado = agenda.buscarContacto(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombreBuscar);
                    }
                }
                case 3 -> {
                    System.out.println("*** ELIMINAR CONTACTO ***");
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                }
                case 4 -> {
                    System.out.println();
                    agenda.listarContactos();
                }
                case 5 -> {
                    System.out.println();
                    agenda.listarHistorial();
                }
                case 6 -> {
                    System.out.println("*** AGREGAR GRUPO ***");
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();
                    agenda.agregarGrupo(nombreGrupo);
                }
                case 7 -> {
                    System.out.println("*** AGREGAR CONTACTO A GRUPO ***");
                    System.out.print("Nombre del contacto: ");
                    String cGrupo = scanner.nextLine();
                    System.out.print("Nombre del grupo: ");
                    String gContacto = scanner.nextLine();
                    agenda.agregarContactoAGrupo(cGrupo, gContacto);
                }
                case 8 -> {
                    System.out.println();
                    agenda.listarGrupos();
                }
                case 9 -> {
                    System.out.println("*** MOSTRAR CONTACTOS POR GRUPO ***");
                    System.out.print("Nombre del grupo: ");
                    String grupoMostrar = scanner.nextLine();
                    agenda.mostrarContactosPorGrupo(grupoMostrar);
                }
                case 10 -> System.out.println("Saliendo de la agenda...");
                default -> System.out.println("Opcion invalida, intenta de nuevo");
            }

        } while (opcion != 10);

        scanner.close();
    }
}
