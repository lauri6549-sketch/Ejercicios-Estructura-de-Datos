import java.util.Scanner;

public class GestorProfesores {
    private LinkedList<Profesor> profesores;

    public GestorProfesores() {
        this.profesores = new LinkedList<>();
    }

    public void agregar (Profesor p){
        profesores.add(p);
    }

   public void pedirAgregar(Scanner in) {
        String nombre;
        while (true) {
            System.out.print("Ingrese el nombre: ");
            nombre = in.nextLine();
            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("ERROR: El nombre no puede estar vacío");
            } else if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$")) {
                System.out.println("ERROR: Nombre Inválido (solo letras y espacios)");
            } else {
                break;
            }
        }

        int edad;
        while (true) {
            System.out.print("Ingrese la edad: ");
            if (in.hasNextInt()) {
                edad = in.nextInt();
                in.nextLine();
                if (edad > 18 && edad < 120){
                    break;
                } 
                System.out.println("ERROR: La edad debe estar entre 18 y 119");
            } else {
                System.out.print("ERROR: Ingrese un número válido: ");
                in.next();
            }
        }

        String catDoc = "";
        while (true) {
            System.out.println("\nIngrese la categoría docente: ");
            System.out.println("1. Instructor");
            System.out.println("2. Asistente");
            System.out.println("3. Auxiliar");
            System.out.println("4. Titular");
            System.out.print("Opción: ");

            int opCat = validarOpcion(in, 1, 4);
           
            if (opCat == 1) { 
                catDoc = "Instructor"; 
                break; 
            }else if (opCat == 2) { 
                catDoc = "Asistente"; 
                break; 
            }else if (opCat == 3) { 
                catDoc = "Auxiliar"; 
                break; 
            }else { 
                catDoc = "Titular"; 
                break; 
            }
        }

        profesores.add(new Profesor(nombre, edad, catDoc));
        System.out.println("El profesor ha sido agregado correctamente");
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

    public void proxCambio (){
        if (profesores.isEmpty()) {
            System.out.println("ERROR: No hay profesores registrados");
            return;
        }
        LinkedList<String> cambioCateg = new LinkedList<>();
        for (int i=0; i<profesores.size(); i++){
            if (profesores.get(i).getEdad() > 26 && profesores.get(i).getCatDoc().equals("Instructor")) {
                cambioCateg.add(profesores.get(i).getNombre());
            }
        }
        if (cambioCateg.isEmpty()) {
            System.out.println("No hay instructores próximos a cambio de categoría");
            return;
        }

        for(int i=0; i<cambioCateg.size(); i++){
            System.out.println((i+1) + ". "+ cambioCateg.get(i));
        }
    }

    public void mostrarLista (){
        if (profesores.isEmpty()) {
            System.out.println("ERROR: No hay profesores registrados");
            return;
        }
        profesores.mergeSort();
        for (int i=0; i<profesores.size(); i++){
            System.out.println((i+1) +". "+ profesores.get(i).getNombre() +" - "+ profesores.get(i).getEdad()
            +" años - "+ profesores.get(i).getCatDoc());
        }
    }
    
    public String cantProfesores(){
        if (profesores.isEmpty()) {
            return "ERROR: No hay profesores registrados";
        }
        int cantI = 0, cantAs = 0, cantAux = 0, cantT = 0;
        for (int i=0; i<profesores.size(); i++){
            if (profesores.get(i).getCatDoc().equals("Instructor")) {
                cantI++;
            }else if (profesores.get(i).getCatDoc().equals("Asistente")) {
                cantAs++;
            }else if (profesores.get(i).getCatDoc().equals("Auxiliar")) {
                cantAux++;
            }else {
                cantT++;
            }
        }
        return "Instructor: "+ cantI +"\nAsistente: "+ cantAs +"\nAuxiliar: "+ cantAux 
            +"\nTitular: "+ cantT;
    }
}
