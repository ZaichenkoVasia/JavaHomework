package ua.mycompany.collection;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private int size;
    private Link first;
    private Link last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    private Link getLink(int index) {
        Link current = first;
        if (index < size / 2) {
            while (index > 0) {
                current = current.next;
                index--;
            }
        } else {
            current = last;
            index = size - index - 1;
            while (index > 0) {
                current = current.previous;
                index--;
            }
        }
        return current;
    }

    @Override
    public void add(int index, T t) {
        rangeCheck(index);

        Link current = getLink(index);

        Link newLink = new Link(t);

        if (current == first) {
            first = newLink;
        } else {
            current.previous.next = newLink;
        }
        newLink.previous = current.previous;
        newLink.next = current;
        current.previous = newLink;

        size++;

    }

    @Override
    public void add(T t) {
        Link newLink = new Link(t);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }

        newLink.previous = last;
        last = newLink;

        size++;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);

        Link current = getLink(index);

        if (current == first) {
            first = current.next;
        } else
            current.previous.next = current.next;

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        size--;

        return (T) current.data;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        Link current = getLink(index);
        return (T) current.data;
    }

    @Override
    public void set(int index, T t) {
        rangeCheck(index);
        Link current = getLink(index);
        current.data = t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clean() {
        for (int i = 0; i <size ; i++) {
            remove(0);
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){

            Link current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                Link temp = current;
                current = current.next;
                return (T) temp.data;
            }

            @Override
            public void remove() {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current = current.previous;
                size--;
            }
        };
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Incorrect value of index");
    }

    class Link {
        private Object data;
        private Link previous;
        private Link next;

        public Link(Object data) {
            this.data = data;
            previous = null;
            next = null;
        }

        @Override
        public String toString() {
            return (data + " ");
        }
    }
}
