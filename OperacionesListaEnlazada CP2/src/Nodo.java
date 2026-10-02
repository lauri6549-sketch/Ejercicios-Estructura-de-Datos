public class Nodo<E> {
    protected E dato;
    protected Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(E dato, Nodo<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public E getInfo() {
        return dato; 
    }
    
    public void setInfo(E dato) {
        this.dato = dato; 
    }

    public Nodo<E> getNext() { 
        return siguiente; 
    }

    public void setNext(Nodo<E> siguiente) { 
        this.siguiente = siguiente; 
    }
}