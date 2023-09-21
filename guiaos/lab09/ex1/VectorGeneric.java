package lab09.ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return vec[i];
    }

    public Iterator<T> iterator() {
        return new VectorIterator();
    }

    public ListIterator<T> listIterator() {
        return (this).new VectorListIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return (this).new VectorListIterator(index);
    }

    private class VectorIterator implements Iterator<T> {
        private int index;

        VectorIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < nElem;
        }

        @Override
        public T next() {
            if (hasNext())
                return (T) VectorGeneric.this.vec[this.index++];
            throw new IndexOutOfBoundsException("only " + nElem + " elements");
        }
    }

    private class VectorListIterator implements ListIterator<T> {
        private int index;

        VectorListIterator() {
            this.index = 0;
        }

        VectorListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index < nElem;
        }

        @Override
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override
        public T next() {
            if (hasNext())
                return (T) VectorGeneric.this.vec[this.index++];
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        @Override
        public int nextIndex() {
            return this.index + 1;
        }

        @Override
        public T previous() {
            if (hasPrevious())
                return (T) VectorGeneric.this.vec[this.index--];
            throw new IndexOutOfBoundsException("Index out of bounds"); 
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported Operation 'remove'");
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Unsupported Operation 'set'");
        }

        @Override
        public int previousIndex() {
            return this.index - 1;
        }

        @Override
        public void add(T e) {
            VectorGeneric.this.addElem(e);
        }

    }
}
