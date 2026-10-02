import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> lista = new LinkedList<>();

        while (true) {
            System.out.println("\n---MENÚ---");
            System.out.println("1. Crear nueva lista");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Eliminar elementos repetidos");
            System.out.println("4. Rotar una posición a la derecha");
            System.out.println("5. Concatenar con otra lista");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion;
            while (true) {
                if (in.hasNextInt()) {
                    opcion = in.nextInt();
                    in.nextLine();
                    if (opcion >= 1 && opcion <= 6) {
                        break;
                    }    
                    System.out.println("ERROR: El número debe estar entre 1 y 6");
                } else {
                    System.out.print("ERROR: Ingrese un número válido: ");
                    in.next();
                }
            }

            if (opcion == 1) {
                LinkedList<String> nuevaLista = new LinkedList<>();

                int cant;
                System.out.print("Ingrese la cantidad de elementos: ");
                while (true) {
                    if (in.hasNextInt()) {
                        cant = in.nextInt();
                        in.nextLine();
                        if (cant > 0) break;
                        System.out.println("ERROR: La cantidad debe ser mayor a 0");
                    } else {
                        System.out.print("ERROR: Ingrese un número válido: ");
                        in.next();
                    }
                }

                for (int i = 0; i < cant; i++) {
                    String elem;
                    while (true) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        elem = in.nextLine();
                        if (elem == null || elem.trim().isEmpty()) {
                            System.out.println("ERROR: El elemento no puede estar vacío");
                        } else if (!elem.matches("^[a-zA-Z]+$")) {
                            System.out.println("ERROR: El elemento solo puede contener letras");
                        } else {
                            break;
                        }
                    }
                    nuevaLista.add(elem);
                }

                lista = nuevaLista;
                System.out.println("La lista ha sido creada");

            } else if (opcion == 2) {
                lista.mostrar();

            } else if (opcion == 3) {
                lista.eliminarRepetidos();
                lista.mostrar();

            } else if (opcion == 4) {
                lista.rotarDerecha();
                lista.mostrar();

            } else if (opcion == 5) {
                LinkedList<String> lista2 = new LinkedList<>();

                int cant;
                System.out.print("Ingrese la cantidad de elementos de la nueva lista: ");
                while (true) {
                    if (in.hasNextInt()) {
                        cant = in.nextInt();
                        in.nextLine();
                        if (cant > 0) break;
                        System.out.println("ERROR: La cantidad debe ser mayor a 0");
                    } else {
                        System.out.print("ERROR: Ingrese un número válido: ");
                        in.next();
                    }
                }

                for (int i = 0; i < cant; i++) {
                    String elem;
                    while (true) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        elem = in.nextLine();
                        if (elem == null || elem.trim().isEmpty()) {
                            System.out.println("ERROR: El elemento no puede estar vacío");
                        } else if (!elem.matches("^[a-zA-Z]+$")) {
                            System.out.println("ERROR: El elemento solo puede contener letras");
                        } else {
                            break;
                        }
                    }
                    lista2.add(elem);
                }

                lista.concatenar(lista2);
                lista.mostrar();

            } else if (opcion == 6) {
                System.out.println("Ha salido del menú...");
                return;
            }
        }
    }
}