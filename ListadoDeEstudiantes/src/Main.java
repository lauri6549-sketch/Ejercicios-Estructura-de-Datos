import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GestorEstudiante gestor = new GestorEstudiante();

        while (true) {
            System.out.println("\n---MENÚ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes que cumplen años en un mes");
            System.out.println("3. Mostrar militantes de la UJC ordenados por año");
            System.out.println("4. Mostrar cantidad de becados");
            System.out.println("5. Ver casos de prueba");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion = gestor.validarOpcion(in, 1, 6);

            if (opcion == 1) {
                gestor.pedirAgregar(in);

            } else if (opcion == 2) {
                String mes;
                while (true) {
                    System.out.print("Ingrese el mes (desde 01 hasta 12): ");
                    mes = in.nextLine();
                    if (mes == null || !mes.matches("^[0-9]{2}$")) {
                        System.out.println("ERROR: El mes debe tener 2 dígitos");
                    } else if (Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12) {
                        System.out.println("ERROR: El mes debe estar entre 01 y 12");
                    } else {
                        break;
                    }
                }
                gestor.cumpleanios(mes);

            } else if (opcion == 3) {
                gestor.cantMilitantes();

            } else if (opcion == 4) {
                gestor.cantBecados();

            } else if (opcion == 5) {
                System.out.println("\n---CASOS POSITIVOS---");
                GestorEstudiante g1 = new GestorEstudiante();
                g1.agregar(new Estudiante("05031512345", "Juan", "Pérez", "Masculino", 3, true, true));
                g1.agregar(new Estudiante("06042067890", "María", "López", "Femenino", 1, false, false));
                g1.agregar(new Estudiante("07051211111", "Pedro", "Gómez", "Masculino", 2, true, false));
                g1.agregar(new Estudiante("08061022222", "Ana", "Martínez", "Femenino", 4, true, true));
                g1.agregar(new Estudiante("09072033333", "Luis", "Rodríguez", "Masculino", 5, false, true));

                System.out.println("\n1. Estudiantes que cumplen años en marzo (03):");
                g1.cumpleanios("03");

                System.out.println("\n2. Militantes de la UJC ordenados por año:");
                g1.cantMilitantes();

                System.out.println("\n3. Cantidad de becados:");
                g1.cantBecados();

                System.out.println("\n---CASOS NEGATIVOS---");

                System.out.println("\n1. Sin estudiantes:");
                GestorEstudiante g2 = new GestorEstudiante();
                g2.cumpleanios("03");
                g2.cantMilitantes();
                g2.cantBecados();

                System.out.println("\n2. Estudiantes registrados, pero ninguno cumple en diciembre (12):");
                g2.agregar(new Estudiante("05031512345", "Juan", "Pérez", "Masculino", 3, false, false));
                g2.cumpleanios("12");

                System.out.println("\n3. Sin militantes:");
                g2.cantMilitantes();

                System.out.println("\n4. Sin becados:");
                g2.cantBecados();

                System.out.println("\n5. Todos con la misma edad:");
                GestorEstudiante g3 = new GestorEstudiante();
                g3.agregar(new Estudiante("05031512345", "Luis", "Bosque", "Masculino", 3, true, true));
                g3.agregar(new Estudiante("06042067890", "Juana", "Dìaz", "Femenino", 3, true, false));
                g3.agregar(new Estudiante("07051211111", "Daniel", "Fernández", "Masculino", 3, true, true));
                g3.cantMilitantes();

                System.out.println("\n6. Todos los becados:");
                GestorEstudiante g4 = new GestorEstudiante();
                g4.agregar(new Estudiante("05031512345", "Ariel", "Barrios", "Masculino", 1, false, true));
                g4.agregar(new Estudiante("06042067890", "Coco", "Domínguez", "Femenino", 2, false, true));
                g4.cantBecados();

                System.out.println("\n7. Todos cumplen en el mismo mes:");
                GestorEstudiante g5 = new GestorEstudiante();
                g5.agregar(new Estudiante("05031512345", "Alejandro", "Barracuda", "Masculino", 1, false, false));
                g5.agregar(new Estudiante("06031567890", "Cameron", "Jiménez", "Femenino", 2, false, false));
                g5.cumpleanios("03");

            } else if (opcion == 6) {
                System.out.println("Ha salido del menú...");
                return;
            }
        }
    }
}
