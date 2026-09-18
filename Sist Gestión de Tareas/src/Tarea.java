public class Tarea{
    private String titulo;
    private int tiempoEstimado;
    private Prioridad prioridad;

    public Tarea (String titulo, int tiempoEstimado, Prioridad prioridad){
        this.titulo = titulo;
        this.tiempoEstimado = tiempoEstimado;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
}