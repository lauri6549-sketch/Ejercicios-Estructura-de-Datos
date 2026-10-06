import java.util.Scanner;

public class GestorEstudiante {
    private LinkedList<Estudiante> estudiantes;

    public GestorEstudiante() {
        this.estudiantes = new LinkedList<>();
    }

    public void agregar(Estudiante e) {
        estudiantes.add(e);
    }

    public void pedirAgregar(Scanner in) {
        String ci;
        while (true) {
            System.out.print("Ingrese el CI (11 dígitos): ");
            ci = in.nextLine();
            if (ci == null || !ci.matches("^[0-9]{11}$")) {
                System.out.println("ERROR: CI inválido (11 dígitos numéricos)");
            } else {
                int mes = Integer.parseInt(ci.substring(2, 4));
                if (mes < 1 || mes > 12) {
                    System.out.println("ERROR: Mes del CI inválido (01-12)");
                } else {
                    int dia = Integer.parseInt(ci.substring(4, 6));
                    int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                    int anioCI = Integer.parseInt(ci.substring(0, 2));
                    int anioCompleto;
                    if (anioCI >= 95) {
                        anioCompleto = 1900 + anioCI; 
                    } else {
                        anioCompleto = 2000 + anioCI;
                    }

                    if ((anioCompleto % 4 == 0 && anioCompleto % 100 != 0) || anioCompleto % 400 == 0) {
                        diasPorMes[1] = 29;
                    }
                    if (dia < 1 || dia > diasPorMes[mes - 1]) {
                        System.out.println("ERROR: El día del CI no es válido para el mes " + mes);
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = in.nextLine();
        nombre = validarNombreYApellido(in, nombre);

        System.out.print("Ingrese el apellido: ");
        String apellido = in.nextLine();
        apellido = validarNombreYApellido(in, apellido);

        String sexo = "";
        System.out.println("\nIngrese el sexo: ");
        while (true) {
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.print("Opción: ");

            int opSexo = validarOpcion(in, 1, 2);

            if (opSexo == 1) {
                sexo = "Masculino";
                break;
            } else {
                sexo = "Femenino";
                break;
            }
        }

        int anio;
        while (true) {
            System.out.print("Ingrese el año (1-4): ");
            if (in.hasNextInt()) {
                anio = in.nextInt();
                in.nextLine();
                if (anio >= 1 && anio <= 4) {
                    break;
                }
                System.out.println("ERROR: Año inválido (debe estar entre 1 y 4)");
            } else {
                System.out.print("ERROR: Ingrese un número válido: ");
                in.next();
            }
        }

        boolean militanteUJC = false;
        while (true) {
            System.out.print("Ingrese si es militante de la UJC (si/no): ");
            String resp = in.nextLine();
            if (resp.equalsIgnoreCase("si")) {
                militanteUJC = true;
                break;
            } else if (resp.equalsIgnoreCase("no")) {
                militanteUJC = false;
                break;
            } else {
                System.out.println("ERROR: Ingrese 'si' o 'no'");
            }
        }

        boolean becado = false;
        while (true) {
            System.out.print("Ingrese si es becado (si/no): ");
            String resp = in.nextLine();
            if (resp.equalsIgnoreCase("si")) {
                becado = true;
                break;
            } else if (resp.equalsIgnoreCase("no")) {
                becado = false;
                break;
            } else {
                System.out.println("ERROR: Ingrese 'si' o 'no'");
            }
        }

        estudiantes.add(new Estudiante(ci, nombre, apellido, sexo, anio, militanteUJC, becado));
        System.out.println("Estudiante ha sido agregado correctamente");
    }

    public int validarOpcion(Scanner in, int min, int max) {
        int op;
        while (true) {
            if (in.hasNextInt()) {
                op = in.nextInt();
                in.nextLine();
                if (op >= min && op <= max) {
                    return op;
                }
                System.out.println("ERROR: El número debe estar entre " + min + " y " + max);
            } else {
                System.out.print("ERROR: Ingrese un número válido: ");
                in.next();
            }
        }
    }

    public String validarNombreYApellido(Scanner in, String palabra) {
        while (true) {
            if (palabra == null || palabra.trim().isEmpty()) {
                System.out.println("ERROR: El nombre/apellido no puede estar vacío");
            } else if (!palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$")) {
                System.out.println("ERROR: Nombre/Apellido inválido (solo letras y espacios)");
            } else {
                return palabra;
            }
            System.out.print("Ingrese de nuevo el dato: ");
            palabra = in.nextLine();
        }
    }

    public void cumpleanios(String mes) {
        if (estudiantes.isEmpty()) {
            System.out.println("ERROR: No hay estudiantes registrados");
            return;
        }
        if (mes == null || !mes.matches("^[0-9]{2}$")) {
            System.out.println("ERROR: Mes inválido (desde 01 hasta 12)");
            return;
        }

        LinkedList<String> listCumpl = new LinkedList<>();
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCi().substring(2, 4).equals(mes)) {
                listCumpl.add(estudiantes.get(i).getNombre());
            }
        }

        if (listCumpl.isEmpty()) {
            System.out.println("No hay estudiantes que cumplan años en el mes " + mes);
            return;
        }

        for (int i = 0; i < listCumpl.size(); i++) {
            System.out.println((i + 1) + ". " + listCumpl.get(i));
        }
    }

    public void cantMilitantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("ERROR: No hay estudiantes registrados");
            return;
        }

        LinkedList<Estudiante> militantes = new LinkedList<>();
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).isMilitanteUJC()) {
                militantes.add(estudiantes.get(i));
            }
        }

        if (militantes.isEmpty()) {
            System.out.println("No hay estudiantes militantes de la UJC");
            return;
        }

        militantes.mergeSort();
        for (int i = 0; i < militantes.size(); i++) {
            System.out.println((i + 1) + ". " + militantes.get(i).getCi() + " - " + militantes.get(i).getNombre() 
                    + " - " + militantes.get(i).getApellido()+ " - " + militantes.get(i).getSexo() + " - " 
                    + militantes.get(i).getAnio()+ " - " + militantes.get(i).isMilitanteUJC() + " - " 
                    + militantes.get(i).isBecado());
        }
    }

    public void cantBecados() {
        if (estudiantes.isEmpty()) {
            System.out.println("ERROR: No hay estudiantes registrados");
            return;
        }

        int cant = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).isBecado()) {
                cant++;
            }
        }
        System.out.println("Becados: " + cant);
    }
}