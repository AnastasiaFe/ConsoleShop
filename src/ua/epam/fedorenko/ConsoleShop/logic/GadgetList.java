package ua.epam.fedorenko.ConsoleShop.logic;

import java.util.*;
import java.util.function.Predicate;

public class GadgetList<E> implements List<E> {

    /**
     * initial size of the list
     */
    private static final int INITIAL_SIZE = 10;

    /**
     * array of gadgets which list holds
     */
    private E[] gadgets;

    /**
     * real number of elements in the list
     */
    private int capacity;


    public GadgetList(int initialSize) {
        if (initialSize >= 0) {
            gadgets = (E[]) new Object[initialSize];
        }
    }

    public GadgetList() {
        this(INITIAL_SIZE);
    }

    public GadgetList(Collection<? extends E> c) {
        gadgets = (E[]) c.toArray();
        if ((capacity = gadgets.length) != 0) {

            gadgets = Arrays.copyOf(gadgets, capacity);
        } else {

            this.gadgets = (E[]) new Object[]{};
        }

    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new GadgetIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(gadgets, capacity);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < capacity) {
            return (T[]) Arrays.copyOf(gadgets, capacity, a.getClass());
        }
        System.arraycopy(gadgets, 0, a, 0, capacity);
        if (a.length > capacity) {
            a[capacity] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        makeNecessaryCapacity(capacity + 1);
        gadgets[capacity++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < gadgets.length; i++) {
            if (Objects.equals(gadgets[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] gadgets2 = c.toArray();
        int count = 0;
        for (Object o : gadgets2) {
            if (this.contains(o)) {
                count++;
            }
        }
        return count == gadgets2.length;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int newCollectionSize = a.length;
        makeNecessaryCapacity(capacity + newCollectionSize);
        System.arraycopy(a, 0, gadgets, capacity, newCollectionSize);
        capacity += newCollectionSize;
        return newCollectionSize != 0;

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndexForAdding(index);
        Object[] a = c.toArray();
        int newCollectionSize = a.length;
        makeNecessaryCapacity(capacity + newCollectionSize);
        int numMoved = capacity - index;
        if (numMoved > 0) {
            System.arraycopy(gadgets, index, gadgets, index + newCollectionSize, numMoved);
        }
        System.arraycopy(a, 0, gadgets, index, newCollectionSize);
        capacity += newCollectionSize;
        return newCollectionSize != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return removeCollection(c, false);
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return removeCollection(c, true);
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            gadgets[i] = null;
        }
        capacity = 0;

    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return gadgets[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E previousElement = gadgets[index];
        gadgets[index] = element;
        return previousElement;

    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdding(index);
        makeNecessaryCapacity(capacity + 1);
        System.arraycopy(gadgets, index, gadgets, index + 1, capacity - index);
        gadgets[index] = element;
        capacity++;

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = gadgets[index];
        int numberOfElementsToMove = capacity - index - 1;
        if (numberOfElementsToMove > 0) {
            System.arraycopy(gadgets, index + 1, gadgets, index, numberOfElementsToMove);
        }
        gadgets[--capacity] = null;

        return oldValue;

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(gadgets[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = capacity - 1; i >= 0; i++) {
            if (Objects.equals(gadgets[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    private class GadgetIterator implements Iterator<E> {
        /**
         * last returned index of the list
         */
        private int lastReturnedIndex = -1;

        /**
         * next index which should be returned
         */
        private int nextIndexToReturn;

        @Override
        public boolean hasNext() {
            return nextIndexToReturn != capacity;
        }

        @Override
        public E next() {
            if (nextIndexToReturn >= capacity) {
                throw new NoSuchElementException();
            }
            lastReturnedIndex = nextIndexToReturn++;
            return gadgets[lastReturnedIndex];
        }

        @Override
        public void remove() {
            if (lastReturnedIndex < 0) {
                throw new IllegalStateException();
            }
            GadgetList.this.remove(lastReturnedIndex);
            nextIndexToReturn = lastReturnedIndex;
            lastReturnedIndex = -1;
        }
    }

    private class FilterIterator implements Iterator<E>
    {
        /**
         * the iterator being used
         */
        private Iterator<E> iterator;
        /**
         * the predicate being used
         */
        private Predicate<E> predicate;
        /**
         * next element in the iteration
         */
        private E nextElement;
        /**
         * Whether the next element has been calculated yet
         */
        private boolean isNextElementSet = false;


        public FilterIterator(Iterator<E> iterator, Predicate<E> predicate) {
            this.iterator = iterator;
            this.predicate = predicate;
        }

        /**
         * Set nextElement to the next element. If there are no more
         * objects then return false. Otherwise, return true.
         */
        private boolean setNextObject() {
            while (iterator.hasNext()) {
                final E current = iterator.next();
                if (predicate.test(current)) {
                    nextElement = current;
                    isNextElementSet = true;
                    return true;
                }
            }
            return false;
        }


        @Override
        public boolean hasNext() {
            return isNextElementSet || setNextObject();
        }

        @Override
        public void remove() {
            if (isNextElementSet) {
                throw new IllegalStateException("Remove method cannot be called!");
            }
            iterator.remove();
        }

        /**
         *
         * @return gets next element in the collection which matches condition
         */
        @Override
        public E next() {
            if (!isNextElementSet) {
                if (!setNextObject()) {
                    throw new NoSuchElementException();
                }
            }
            isNextElementSet = false;
            return nextElement;
        }
    }

    /**
     * checks if it is possible to add the element to the index
     *
     * @param index index to check
     */
    private void checkIndexForAdding(int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
    }

    /**
     * Increases the capacity of GadgetList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void makeNecessaryCapacity(int minCapacity) {
        int previousCapacity = gadgets.length;
        if (minCapacity > previousCapacity) {
            int newCapacity = (previousCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            gadgets = Arrays.copyOf(gadgets, newCapacity);
        }
    }


    /**
     * removes the collection from list
     *
     * @param c          collection containing elements to be removed in this list
     * @param complement true if you need to retain, false if you need to remove
     * @return true if the list was changed, false - otherwise
     */
    private boolean removeCollection(Collection<?> c, boolean complement) {
        final Object[] elements = this.gadgets;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < capacity; r++) {
                if (c.contains(elements[r]) == complement) {
                    elements[w++] = elements[r];
                }
            }
        } finally {
            if (r != capacity) {
                System.arraycopy(elements, r, elements, w, capacity - r);
                w += capacity - r;
            }
            if (w != capacity) {
                for (int i = w; i < capacity; i++) {
                    elements[i] = null;
                }
                capacity = w;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * checks if the index fits the list bounds
     *
     * @param index index to check
     */
    private void checkIndex(int index) {
        if (index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
    }
}
