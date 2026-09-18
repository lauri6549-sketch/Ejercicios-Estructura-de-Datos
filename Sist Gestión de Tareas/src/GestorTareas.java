public class GestorTareas {
    private ArrayList<Tarea> tareas;

    public GestorTareas (){
        this.tareas = new ArrayList<>();
    }

    public void anadirTarea(Tarea tarea){
        if (!validarNombre(tarea.getTitulo())) {
            System.out.println("ERROR: El título solo puede contener letras");
            return;
        }
        if (tarea.getTiempoEstimado() <= 0) {
            System.out.println("ERROR: El tiempo debe ser mayor a 0");
            return;
        }
        if (tarea.getPrioridad() == null) {
            System.out.println("ERROR: La prioridad no puede ser nula");
            return;
        }
        tareas.add(tarea);
        System.out.println("Tarea añadida correctamente");
    }

    public static boolean validarNombre(String nombre) {
        if (nombre == null) {
            return false;
        }

        return nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$") && !nombre.trim().isEmpty();
    }

    public Tarea completarTareaSig (){
        if (tareas.isEmpty()){
            System.out.println("No hay tareas pendientes");
            return null;
        }
        return tareas.removeFirst();
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i+1) +". "+ tareas.get(i).getTitulo() + " - " + tareas.get(i).getTiempoEstimado()
                    + " - "+ tareas.get(i).getPrioridad());
        }
    }

    public void contarTareasPorPrioridad() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes");
            return;
        }
        int altas = 0, medias = 0, bajas = 0;
        for (int i = 0; i < tareas.size(); i++) {
            Prioridad p = tareas.get(i).getPrioridad();
            if (p == Prioridad.ALTA) {
                altas++;
            } else if (p == Prioridad.MEDIA) {
                medias++;
            } else if (p == Prioridad.BAJA) {
                bajas++;
            }
        }
        System.out.println("Tareas: "+ "\nAlta:  " + altas);
        System.out.println("Media: " + medias);
        System.out.println("Baja:  " + bajas);
        System.out.println("Total: " + tareas.size());
    }

    public void priorizarTareas(){
        if (tareas.isEmpty()){
            System.out.println("No hay tareas pendientes");
            return;
        }
        ArrayList<Tarea> tareasAlta = new ArrayList<>();
        ArrayList<Tarea> tareasMediaBaja = new ArrayList<>();

        for (int i=0; i<tareas.size(); i++){
            if (tareas.get(i).getPrioridad() == Prioridad.ALTA){
                tareasAlta.add(tareas.get(i));
            }else {
                tareasMediaBaja.add(tareas.get(i));
            }
        }

        if (tareasAlta.isEmpty()){
            System.out.println("No hay tareas de prioridad ALTA");
            return;
        }

        tareas.clear();
        tareas.addAll(tareasAlta);
        tareas.addAll(tareasMediaBaja);

        System.out.println("Las tareas fueron priorizadas exitosamente");
    }

    public void clear(){
        tareas.clear();
    }
}
