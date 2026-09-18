public interface List<E> {
    void add(E e);
    void addAll(List<E> e);
    E removeFirst();
    E get(int index);
    int size();
    void clear();
    boolean isEmpty();
}