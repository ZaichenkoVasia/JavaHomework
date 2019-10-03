package ua.mycompany.collection;

public interface List<T> extends Iterable<T> {

    void add(int index, T t);

    void add(T t);

    T remove(int index);

    T get(int index);

    void set(int index, T t);

    int size();

    boolean isEmpty();

    void clean();
}
