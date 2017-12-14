package com.chuyuqiao.dsandaa.list;

import com.chuyuqiao.dsandaa.AbstractADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> extends AbstractADT<T> implements Iterable<T> {
    /**
     * default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * size
     */
    private int theSize;
    /**
     * element
     */
    private T[] theItems;

    /**
     * Constructor
     */
    public MyArrayList() {
        doClear();
    }

    /**
     * clear
     */
    public void clear() {
        doClear();
    }

    /**
     * doClear
     */
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * ensureCapacity
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    /**
     * size
     *
     * @return
     */
    public int size() {
        return theSize;
    }

    /**
     * isEmpty
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * trimToSize
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * get
     *
     * @param idx
     * @return
     */
    public T get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    /**
     * set
     *
     * @param idx
     * @param newVal
     * @return
     */
    public T set(int idx, T newVal) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    /**
     * add
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    /**
     * add
     *
     * @param idx
     * @param t
     */
    private void add(int idx, T t) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize; i > idx; i--)
            theItems[i] = theItems[i - 1];
        theItems[idx] = t;
        theSize++;
    }

    /**
     * remove
     *
     * @param idx
     * @return
     */
    public T remove(int idx) {
        T removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++)
            theItems[i] = theItems[i + 1];
        theSize--;
        return removedItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<T> implements Iterator<T> {
        private int cuurent = 0;
        @Override
        public boolean hasNext() {
            return cuurent < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return (T) theItems[cuurent++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--cuurent);
        }
    }
}
