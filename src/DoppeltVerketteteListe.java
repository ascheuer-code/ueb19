import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoppeltVerketteteListe<E> implements List<E> {

    public DoppeltVerketteteListe() {
        this.size = 0;
    }

    private Knoten head;
    private Knoten tail;
    private int size;

    public int getSize() {
        return size;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        return (this.getSize() == 0) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        Knoten neu = head;
        if (this.getSize() == 0) {
            return false;
        }
        if (head.equals(o)) {
            return true;
        }
        if (!head.equals(o) && head.getNext().equals(o)) {
            return true;
        }
        if (!head.equals(o) && !head.getNext().equals(o)) {
            for (int i = 0; i < this.getSize(); i++) {
                if (neu.getNext() != null) {
                    neu = head.getNext();
                }
                if (neu.getNext() == null) {
                    return false;
                }
                if (neu.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // Object[] b = new Object[this.size];
        // b = a;
        // return (T[]) b;

        return (T[]) Arrays.stream(a).toArray(Object[]::new);
    }

    @Override
    public boolean add(E e) {
        Knoten neu = new Knoten(e);
        if (size == 0) {
            head = neu;
        }
        if (size == 1) {
            tail = neu;
            head.setNext(tail);
            tail.setPrev(head);
        }
        if (size > 1) {
            Knoten temp = tail;
            tail = neu;
            tail.setPrev(temp);
            temp.setNext(tail);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = null;
            return true;
        }
        if (size == 2) {
            tail = null;
            return true;
        }
        if (size > 2) {
            Knoten newTail = tail.getPrev();
            tail = newTail;
            tail.setNext(null);
            return true;
        }
        return true;
    }

    @Override
    public void clear() {
        head.setNext(null);
        tail.setPrev(null);
        head = null;
        tail = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Knoten next = head;
        if (this.size == 0) {
            throw new NullPointerException();
        }
        if (size == 1) {
            return (E) next;
        }
        for (int i = 0; i < index; i++) {

            next = head.getNext();
        }
        return (E) next;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        Knoten next = head;
        if (this.size == 0) {
            throw new NullPointerException();
        }
        if (size == 1) {
            next.setValue(element);
            return (E) next;
        }
        for (int i = 0; i < index; i++) {

            next = head.getNext();
        }
        next.setValue(element);
        return (E) next;
    }

    @Override
    public void add(int index, E element) {
        Knoten neu = new Knoten(element);
        ;
        if (this.size == 0) {
            head = neu;
            return;
        }
        if (this.size < index) {
            Knoten temp = tail;
            tail = neu;
            tail.setPrev(temp);
            temp.setNext(tail);
            return;
        } else {
            Knoten temp = (Knoten) get(index);
            temp.getPrev().setNext(neu);
            neu.setPrev(temp.getPrev());

            neu.setNext(temp);
            temp.setPrev(neu);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {

        if (size == 0) {
            throw new NullPointerException();
        }
        if (this.size < index) {
            throw new NullPointerException();
        }
        if (this.size == index) {
            Knoten temp = tail.getPrev();
            tail = tail.getPrev();
            temp.setNext(null);
            return (E) tail;
        } else {
            Knoten temp = (Knoten) get(index);
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            return (E) temp;
        }
    }

    @Override
    public int indexOf(Object o) {
        if (this.size == 0) {
            throw new NullPointerException();
        }
        if (this.size == 1) {
            return (head.equals(o)) ? 1 : -1;
        }
        if (this.size > 1) {
            Knoten next = head;
            for (int i = 0; i < this.size; i++) {
                if (next.equals(o)) {
                    return i;
                }
                next = next.getNext();
            }
            return -1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
}
