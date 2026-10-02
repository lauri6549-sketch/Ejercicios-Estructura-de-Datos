public interface List<E> {
    void add(E e);
    E remove(int index);
    E get(int index);
    int size();
    void clear();
    boolean isEmpty();
}
