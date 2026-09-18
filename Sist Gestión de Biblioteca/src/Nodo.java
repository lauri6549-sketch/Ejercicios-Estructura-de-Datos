public class Nodo<E> {
    protected E dato;
    protected Nodo<E> next;

    public Nodo(E dato) {
        this.dato = dato;
        this.next = null;
    }

    public Nodo(E info, Nodo<E> next) {
        this.dato = info;
        this.next = next;
    }

    public E getInfo() {
        return dato;
    }

    public void setInfo(E info) {
        this.dato = info;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
}