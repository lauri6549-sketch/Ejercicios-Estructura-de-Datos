public class Main {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();

        System.out.println("---PRUEBAS POSITIVAS---");

        System.out.println("\n1. Añadir Tareas: ");
        gestorTareas.anadirTarea(new Tarea("Estudiar Java", 60, Prioridad.ALTA));
        gestorTareas.anadirTarea(new Tarea("Hacer ejercicio", 30, Prioridad.MEDIA));
        gestorTareas.anadirTarea(new Tarea("Leer libro", 45, Prioridad.BAJA));
        gestorTareas.anadirTarea(new Tarea("Entregar informe", 120, Prioridad.ALTA));

        System.out.println("\n2. Mostrar tareas: ");
        gestorTareas.mostrarTareas();

        System.out.println("\n3. Contar tareas por prioridades: ");
        gestorTareas.contarTareasPorPrioridad();

        System.out.println("\n4. Priorizar tareas urgentes (ALTA): ");
        gestorTareas.priorizarTareas();
        System.out.println("\nLista actualizada:");
        gestorTareas.mostrarTareas();

        System.out.println("\n5. Completar tarea: ");
        Tarea completada = gestorTareas.completarTareaSig();
        System.out.println("Título: " + completada.getTitulo());

        System.out.println("\n Lista actualizada: ");
        gestorTareas.mostrarTareas();

        System.out.println("\n6. Contar por prioridad después de completar de tarea: ");
        gestorTareas.contarTareasPorPrioridad();

        System.out.println("\n---PRUEBAS NEGATIVAS---");

        System.out.println("\nAñadir tarea: ");
        System.out.println("1. Título con números: ");
        gestorTareas.anadirTarea(new Tarea("1234", 60, Prioridad.ALTA));

        System.out.println("2. Título con solo espacios: ");
        gestorTareas.anadirTarea(new Tarea("   ", 30, Prioridad.BAJA));

        System.out.println("3. Título es null:  ");
        gestorTareas.anadirTarea(new Tarea(null, 60, Prioridad.ALTA));

        System.out.println("4. Tiempo es negativo: ");
        gestorTareas.anadirTarea(new Tarea("Estudiar", -10, Prioridad.ALTA));

        System.out.println("5. Tiempo es cero");
        gestorTareas.anadirTarea(new Tarea("Limpiar", 0, Prioridad.MEDIA));

        System.out.println("6. Prioridad sea null: ");
        gestorTareas.anadirTarea(new Tarea("Estudiar ED", 120, null));

        System.out.println("\nCompletar tarea: ");
        System.out.println("1. Con lista vacía: ");
        gestorTareas.clear();
        gestorTareas.completarTareaSig();

        System.out.println("2. Después de completar todas las tareas (lista vacía): ");
        gestorTareas.anadirTarea(new Tarea("Estudiar", 60, Prioridad.MEDIA));
        gestorTareas.anadirTarea(new Tarea("Limpiar", 45, Prioridad.BAJA));
        gestorTareas.completarTareaSig();  // Queda 1
        gestorTareas.completarTareaSig();  // Queda 0
        gestorTareas.completarTareaSig();  // Lista vacía

        System.out.println("\nMostrar tareas con lista vacía: ");
        gestorTareas.mostrarTareas();

        System.out.println("\nContar tareas por prioridades con lista vacía");
        gestorTareas.contarTareasPorPrioridad();

        System.out.println("\nPriorizar tareas urgentes (ALTA): ");
        System.out.println("1. Con lista vacía: ");
        gestorTareas.priorizarTareas();

        System.out.println("2. Sin tareas ALTA:  ");
        gestorTareas.anadirTarea(new Tarea("Estudiar", 60, Prioridad.MEDIA));
        gestorTareas.anadirTarea(new Tarea("Limpiar", 45, Prioridad.BAJA));
        gestorTareas.priorizarTareas();
    }
}
