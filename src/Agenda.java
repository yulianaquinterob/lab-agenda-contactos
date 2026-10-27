import java.util.*;

public class Agenda {
   private Map<String, Contacto> contactos = new TreeMap<>();
   private Set<String> grupos = new TreeSet<>();
   private Map <String, Set<String>> relacionGrupoContacto = new TreeMap<>();
   private List<Contacto> historial = new ArrayList<>();


    public boolean agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Ya existe un contacto con el nombre: "+c.getNombre());
            return false;
        }
        contactos.put(c.getNombre(),c);
        historial.add(c);
        System.out.println("Contacto agregado "+c.getNombre());
        return true;
    }
    public Contacto buscarContacto(String nombre){
        return contactos.get(nombre);

    }

    public boolean eliminarContacto(String nombre){
        Contacto c = contactos.remove(nombre);
        if( c == null){
            System.out.println("Contacto no encontrado"+ nombre);
        }
        historial.remove(c);
        for (Set<String> contactos : relacionGrupoContacto.values()) {
           contactos.remove(nombre);
        }
        System.out.println("Contacto eliminado: " + nombre);
        return true;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.println("LISTA DE CONTACTOS (orden alfabético):");
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }

    public void listarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println("HISTORIAL (orden de inserción):");
        for (Contacto c : historial) {
            System.out.println(c);
        }
    }

    public boolean agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
            return false;
        }
        grupos.add(nombreGrupo);
        relacionGrupoContacto.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo '" + nombreGrupo + "' creado");
        return true;
    }

    public boolean agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return false;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return false;
        }

        relacionGrupoContacto.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
        return true;
    }

    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return;
        }
        System.out.println("LISTA DE GRUPOS:");
        for (String g : grupos) {
            System.out.println("- " + g);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo " + nombreGrupo + " no existe");
            return;
        }

        Set<String> miembros = relacionGrupoContacto.get(nombreGrupo);
        if (miembros == null || miembros.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }

        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombreContacto : miembros) {
            Contacto c = contactos.get(nombreContacto);
            if (c != null) {
                System.out.println(c);
            }
        }
    }

}





