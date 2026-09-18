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
            Nodo<E> cursor = head;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                head = new Nodo<E>(e, head);
            } else {
                Nodo<E> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                Nodo<E> node = new Nodo<>(e);
                node.setNext(cursor.getNext());
                cursor.setNext(node);
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
                Nodo<E> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                aux = cursor.getNext();
                cursor.setNext(aux.getNext());
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
            Nodo<E> cursor = head;
            for (int i = 0; i < index; i++) {
                cursor = cursor.getNext();
            }
            return cursor.getInfo();
        } else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    public void invertir(){
        Nodo<E> anterior = null;
        Nodo<E> actual = head;
        Nodo<E> siguiente;

        while (actual != null){
            siguiente = actual.getNext();
            actual.setNext(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
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
}
