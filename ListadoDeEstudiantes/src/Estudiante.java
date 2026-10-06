public class Estudiante implements Comparable<Estudiante> {
    private String ci;
    private String nombre;
    private String apellido;
    private String sexo;
    private int anio;
    private boolean militanteUJC;
    private boolean becado;
    
    public Estudiante(String ci, String nombre, String apellido, String sexo, int anio, boolean militanteUJC,
            boolean becado) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.anio = anio;
        this.militanteUJC = militanteUJC;
        this.becado = becado;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isMilitanteUJC() {
        return militanteUJC;
    }

    public boolean isBecado() {
        return becado;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return this.anio - otro.anio;
    }
}
