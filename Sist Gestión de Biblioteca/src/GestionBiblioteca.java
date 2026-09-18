public class GestionBiblioteca {
    private LinkedList<Libro> catalogo;

    public GestionBiblioteca() {
        this.catalogo = new LinkedList<>();
    }

    public void anadirLibro(Libro libro){
        if (!validarNombre(libro.getTitulo())) {
            System.out.println("ERROR: Título inválido (solo letras y espacios)");
            return;
        }
        if (!validarNombre(libro.getAutor())) {
            System.out.println("ERROR: Nombre del autor inválido (solo letras y espacios)");
            return;
        }
        if (!validarNombre(libro.getGenero())) {
            System.out.println("ERROR: Género inválido (solo letras y espacios)");
            return;
        }
        if (!validarISBN(libro.getIsbn())) {
            System.out.println("ERROR: ISBN inválido (números o número con guiones)");
            return;
        }
        catalogo.add(libro);
        System.out.println("Libro añadido correctamente");
    }

    public static boolean validarNombre(String nombre) {
        if (nombre == null) {
            return false;
        }
        return nombre.matches("^[a-zA-ZáéèíóúÁÉÍÓÚñÑüÜ ]+$") && !nombre.trim().isEmpty();
    }

    public static boolean validarISBN(String isbn) {
        if (isbn == null) {
            return false;
        }
        return isbn.matches("[0-9]{10}|[0-9]{13}|[0-9-]{10,17}");
    }

    public void prestarLibro(String isbn){
        if (catalogo.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
            return;
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("ERROR: ISBN inválido");
            return;
        }
        int aux = buscarISBN(isbn);
        if (aux != -1) {
            if (!catalogo.get(aux).isPrestado()) {
                catalogo.get(aux).setPrestado(true);
                System.out.println("El libro ha sido prestado");
            }else {
                System.out.println("El libro ya ha sido prestado");
            }
        } else {
            System.out.println("EL libro no existe en la biblioteca");
        }
    }

    public void devolverLibro(String isbn){
        if (catalogo.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
            return;
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("ERROR: ISBN inválido");
            return;
        }
        int aux = buscarISBN(isbn);
        if (aux != -1) {
            if (catalogo.get(aux).isPrestado()) {
                catalogo.get(aux).setPrestado(false);
                System.out.println("El libro ha sido devuelto");
            }else {
                System.out.println("El libro ya se encuentra en la bibloteca");
            }
        } else {
            System.out.println("EL libro no existe en la biblioteca");
        }
    }

    public int buscarISBN(String isbn){
        if (isbn == null) return -1;
        for (int i=0; i< catalogo.size(); i++){
            if (catalogo.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    public void verCatalogo(){
        if (catalogo.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
            return;
        }
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println((i+1) +". "+ catalogo.get(i).getIsbn() + " - " + catalogo.get(i).getTitulo()
                    +" - "+ catalogo.get(i).getAutor() +" - "+ catalogo.get(i).getGenero() +" - "
                    + catalogo.get(i).isPrestado());
        }
    }

    public void invertirCatalogo(){
        if (catalogo.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
            return;
        }
        catalogo.invertir();
        System.out.println("El catalogo ha sido invertido");
    }

    public void recomendarLibro(String genero){
        if (catalogo.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
            return;
        }
        if (genero == null || genero.trim().isEmpty()){
            System.out.println("ERROR: Género inválido");
            return;
        }
        int aux = buscarGenero(genero);
        if (aux != -1) {
            System.out.println("De " + genero + " recomendamos " + catalogo.get(aux).getTitulo() 
            +" de "+ catalogo.get(aux).getAutor());
        } else {
            System.out.println("No hay libros disponibles de ese género");
        }
    }

    public int buscarGenero(String genero){
        for (int i = 0; i < catalogo.size(); i++){
            if (catalogo.get(i).getGenero().equalsIgnoreCase(genero) && !catalogo.get(i).isPrestado()) {
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        catalogo.clear();
    }
}
