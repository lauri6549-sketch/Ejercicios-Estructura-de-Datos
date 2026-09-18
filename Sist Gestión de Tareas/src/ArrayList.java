public class ArrayList<E> implements List<E> {
    private Object[] items;
    private int size;
    private int capacity;

    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.items = new Object[capacity];
    }

    protected void Expand() {
        Object[] aux = new Object[capacity + 10];
        System.arraycopy(items, 0, aux, 0, size);
        capacity += 10;
        items = aux;
    }

    protected boolean isFull() {
        return capacity == size;
    }

    @Override
    public void add(E e) {
        if (isFull()) {
            Expand();
        }
        items[size++] = e;
    }

    @Override
    public void addAll(List<E> otraLista) {
        for (int i = 0; i < otraLista.size(); i++) {
            this.add(otraLista.get(i));
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E aux = (E) items[0];
        for (int i = 0; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size--;
        return aux;
    }

    @Override
    public E get(int index) {
        return (E) items[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        capacity = 10;
        items = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
