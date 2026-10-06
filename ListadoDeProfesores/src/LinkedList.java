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
    public void add(E e, int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                head = new Nodo<E>(e, head);
            } else {
                Nodo<E> actual = head;
                for (int i = 0; i < index - 1; i++) {
                    actual = actual.getNext();
                }
                Nodo<E> node = new Nodo<>(e);
                node.setNext(actual.getNext());
                actual.setNext(node);
            }
            size++;
        } else {
            throw new UnsupportedOperationException("Index out of range");
        }
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

    public void mergeSort() {
        head = mergeSort(head);
    }

    private Nodo<E> mergeSort(Nodo<E> cabeza) {
        if (cabeza == null || cabeza.getNext() == null) {
            return cabeza;
        }

        Nodo<E> mitad1 = obtenerMitad(cabeza);
        Nodo<E> mitad2 = mitad1.getNext();
        mitad1.setNext(null);  

        Nodo<E> izquierda = mergeSort(cabeza);
        Nodo<E> derecha = mergeSort(mitad2);

        return unir(izquierda, derecha);
    }

    private Nodo<E> obtenerMitad(Nodo<E> cabeza) {
        if (cabeza == null){
            return null;
        } 
        Nodo<E> lento = cabeza;
        Nodo<E> rapido = cabeza;
        while (rapido.getNext() != null && rapido.getNext().getNext() != null) {
            lento = lento.getNext();
            rapido = rapido.getNext().getNext();
        }
        return lento;
    }

   private Nodo<E> unir(Nodo<E> izquierda, Nodo<E> derecha) {
        if (izquierda == null){
            return derecha;
        } 
        if (derecha == null){
            return izquierda;
        } 
        Nodo<E> result;

        if (((Comparable<E>) izquierda.getInfo()).compareTo(derecha.getInfo()) >= 0) {
            result = izquierda;
            result.setNext(unir(izquierda.getNext(), derecha));
        } else {
            result = derecha;
            result.setNext(unir(izquierda, derecha.getNext()));
        }
        return result;
    }
}