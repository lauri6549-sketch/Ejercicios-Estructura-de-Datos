import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GestorProfesores gestor = new GestorProfesores();

        while (true) {
            System.out.println("\n---MENÚ---");
            System.out.println("1. Agregar profesor");
            System.out.println("2. Mostrar profesores próximos a cambio");
            System.out.println("3. Mostrar lista ordenada por edad (mayor a menor)");
            System.out.println("4. Mostrar cantidad de profesores por categoría");
            System.out.println("5. Ver casos de prueba");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion = gestor.validarOpcion(in, 1, 6);

            if (opcion == 1) {
                gestor.pedirAgregar(in);

            } else if (opcion == 2) {
                gestor.proxCambio();

            } else if (opcion == 3) {
                gestor.mostrarLista();

            } else if (opcion == 4) {
                System.out.println(gestor.cantProfesores());

            } else if (opcion == 5) {
                System.out.println("\n---CASOS POSITIVOS---");
                GestorProfesores g1 = new GestorProfesores();
                g1.agregar(new Profesor("Juan", 25, "Instructor"));
                g1.agregar(new Profesor("María", 30, "Asistente"));
                g1.agregar(new Profesor("Pedro", 28, "Instructor"));
                g1.agregar(new Profesor("Ana", 35, "Auxiliar"));
                g1.agregar(new Profesor("Luis", 40, "Titular"));

                System.out.println("\n1. Profesores próximos a cambio:");
                g1.proxCambio();

                System.out.println("\n2. Lista ordenada por edad (mayor a menor):");
                g1.mostrarLista();

                System.out.println("\n3. Cantidad por categoría:");
                System.out.println(g1.cantProfesores());

                System.out.println("\n---CASOS NEGATIVOS---");
                GestorProfesores g2 = new GestorProfesores();

                System.out.println("\n1. Sin profesores:");
                g2.proxCambio();
                g2.mostrarLista();
                System.out.println(g2.cantProfesores());

                System.out.println("\n2. Sin instructores con más de 26 años:");
                g2.agregar(new Profesor("Carlos", 22, "Instructor"));
                g2.agregar(new Profesor("Lucía", 24, "Instructor"));
                g2.proxCambio();

                System.out.println("\n3. Instructor de exactamente 26 años (no debe aparecer):");
                GestorProfesores g3 = new GestorProfesores();
                g3.agregar(new Profesor("Pedro", 26, "Instructor"));
                g3.proxCambio();

                System.out.println("\n4. Todos con la misma edad:");
                GestorProfesores g5 = new GestorProfesores();
                g5.agregar(new Profesor("Juana", 30, "Instructor"));
                g5.agregar(new Profesor("Luci", 30, "Asistente"));
                g5.agregar(new Profesor("Pablo", 30, "Auxiliar"));
                g5.mostrarLista();

                System.out.println("\n5. Solo una categoría:");
                GestorProfesores g6 = new GestorProfesores();
                g6.agregar(new Profesor("Juan", 30, "Titular"));
                g6.agregar(new Profesor("Lily", 40, "Titular"));
                System.out.println(g6.cantProfesores());

            } else if (opcion == 6) {
                System.out.println("Ha salido del menú...");
                return;
            }
        }
    }
}
