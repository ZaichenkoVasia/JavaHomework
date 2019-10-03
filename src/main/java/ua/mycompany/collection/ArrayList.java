package ua.mycompany.collection;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {

    private int maxSize;
    private Object[] array;
    private int nItems;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int maxSize) {
        init(maxSize);
    }

    @Override
    public void add(int index, T t) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be more than 0");
        }
        if (nItems >= maxSize) {
            grow();
        }
        for (int i = nItems - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = t;
        nItems++;
    }

    @Override
    public void add(T t) {
        if (nItems >= maxSize) {
            grow();
        }
        array[nItems++] = t;
    }

    private void grow() {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity * 2;

        Object[] newArray = new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, nItems);

        maxSize = newCapacity;
        array = newArray.clone();
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);

        T temp = (T) array[index];

        nItems--;

        for (int i = index; i < nItems; i++) {
            array[i] = array[i + 1];
        }

        return temp;
    }

    private void rangeCheck(int index) {
        if (index >= nItems || index < 0)
            throw new IndexOutOfBoundsException("Index out of range");
    }

    @Override
    public T get(int index) {
        rangeCheck(index);

        return (T) array[index];
    }

    @Override
    public void set(int index, T t) {
        rangeCheck(index);

        array[index] = t;
    }

    @Override
    public int size() {
        return nItems;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clean() {
        init(10);
    }

    private void init(int maxSize) {
        this.maxSize = maxSize;
        this.nItems = 0;
        this.array = new Object[maxSize];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < nItems && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }

            @Override
            public void remove(){
                if(isEmpty()|| currentIndex > nItems-1 || currentIndex < 0){return;}

                nItems--;

                for (int i = currentIndex; i < nItems; i++) {
                    array[i] = array[i + 1];
                }
            }
        };
    }
}
