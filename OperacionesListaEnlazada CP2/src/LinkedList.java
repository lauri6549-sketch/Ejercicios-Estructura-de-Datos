public class LinkedList<E> implements List<E> {
    private Nodo<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(E e) {
        Nodo<E> node = new Nodo<>(e);
        if (isEmpty()) {
            head = node;
        } else {
            Nodo<E> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(node);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            Nodo<E> aux;
            if (index == 0) {
                aux = head;
                head = head.getNext();
            } else {
                Nodo<E> actual = head;
                for (int i = 0; i < index - 1; i++) {
                    actual = actual.getNext();
                }
                aux = actual.getNext();
                actual.setNext(aux.getNext());
            }
            size--;
            return aux.getInfo();
        } else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            Nodo<E> actual = head;
            for (int i = 0; i < index; i++) {
                actual = actual.getNext();
            }
            return actual.getInfo();
        } else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    @Override
    public int size() { 
        return size; 
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { 
        return size == 0; 
    }

    public void eliminarRepetidos() {
        if (head == null) {
            System.out.println("ERROR: La lista está vacía");
            return;
        }

        boolean huboRepetidos = false;
        Nodo<E> actual = head;

        while (actual != null) {
            Nodo<E> anterior = actual;
            Nodo<E> comparador = actual.getNext();
            while (comparador != null) {
                if (actual.getInfo().equals(comparador.getInfo())) {
                    anterior.setNext(comparador.getNext());
                    size--;
                    comparador = anterior.getNext();
                    huboRepetidos = true;
                } else {
                    anterior = comparador;
                    comparador = comparador.getNext();
                }
            }
            actual = actual.getNext();
        }

        if (huboRepetidos) {
            System.out.println("Elementos repetidos eliminados");
        } else {
            System.out.println("No hay elementos repetidos en la lista");
        }
    }

    public void rotarDerecha() {
        if (head == null || head.getNext() == null) {
            System.out.println("ERROR: No se puede rotar (lista vacía o con un solo elemento)");
            return;
        }
        Nodo<E> actual = head;
        while (actual.getNext().getNext() != null) {
            actual = actual.getNext();
        }
        Nodo<E> ultimo = actual.getNext();
        actual.setNext(null);
        ultimo.setNext(head);
        head = ultimo;

        System.out.println("La lista ha sido rotada a la derecha");
    }

    public void concatenar(LinkedList<E> otra) {
        if (head == null) {
            head = otra.head;
            size = otra.size;
            return;
        }
        if (otra.head == null) return;

        Nodo<E> actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(otra.head);
        size += otra.size;

        System.out.println("Las listas han sido concatenadas");
    }

    public void mostrar() {
        if (head == null) {
            System.out.println("ERROR: La lista está vacía");
            return;
        }
        Nodo<E> actual = head;
        while (actual != null) {
            System.out.print(actual.getInfo());
            if (actual.getNext() != null) System.out.print(" - ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}