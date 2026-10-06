public class Profesor implements Comparable<Profesor>{
    private String nombre;
    private int edad;
    private String catDoc;
    
    public Profesor(String nombre, int edad, String catDoc) {
        this.nombre = nombre;
        this.edad = edad;
        this.catDoc = catDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCatDoc() {
        return catDoc;
    }

    @Override
    public int compareTo(Profesor otro) {
        return otro.edad - this.edad;
    }
}
