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
        return (getSize() == 0) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        Knoten neu = head;
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            if (neu.getValue().equals(o)) {
                return true;
            } else {
                return false;
            }
        }
        if (neu.getValue().equals(o)) {
            return true;
        }
        if (!neu.getValue().equals(o)) {
            for (int i = 0; i < getSize(); i++) {
                if (!neu.getValue().equals(o) && neu == tail) {
                    return false;
                }
                if (neu.getNext().getValue() == null) {
                    return false;
                }
                if (neu.getNext().getValue() != null) {
                    neu = neu.getNext();
                }
                if (neu.getValue().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {

        a = (T[]) new Object[size];
        if (size == 0) {
            throw new NullPointerException();
        }
        if (size == 1) {
            a[0] = (T) head;
            return a;
        }
        if (size == 2) {
            a[0] = (T) head;
            a[1] = (T) tail;
            return a;
        }
        if (size > 2) {
            for (int i = 0; i < size; i++) {
                a[i] = (T) get(i);
            }
        }
        return a;
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
            throw new NullPointerException();
        }
        if (size == 1) {
            if (head.getValue().equals(o)) {
                head = null;
                size--;
                return true;
            }
        }
        if (size > 1) {
            Knoten next = head;
            for (int i = 0; i < size; i++) {
                if (next.getValue().equals(o)) {
                    next.getPrev().setNext(next.getNext());
                    next.getNext().setPrev(next.getPrev());
                    next = null;
                    size--;
                    return true;
                }
                next = next.getNext();
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head.setNext(null);
        tail.setPrev(null);
        head = null;
        tail = null;

        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Knoten next = head;
        if (size == 0) {
            throw new NullPointerException();
        }
        if (index == 0) {
            return (E) next;
        }
        if (index == size - 1) {
            return (E) tail;
        }
        for (int i = 0; i < index; i++) {

            next = next.getNext();
        }
        return (E) next;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        Knoten next = head;
        if (size == 0) {
            throw new NullPointerException();
        }
        if (size == 1) {
            next.setValue(element);
            return (E) next;
        }
        for (int i = 0; i < index; i++) {

            next = next.getNext();
        }
        next.setValue(element);
        return (E) next;
    }

    @Override
    public void add(int index, E element) {
        Knoten neu = new Knoten(element);
        ;
        if (size == 0) {
            head = neu;
            return;
        }
        if (size < index) {
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

        if (size == 1 && index == 1) {
            head = null;
        }
        if (size < index) {
            throw new NullPointerException();
        }
        if (size == index && size > 1) {
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
        if (size == 0) {
            throw new NullPointerException();
        }
        if (size == 1) {
            return (head.getValue().equals(o)) ? 1 : -1;
        }
        if (size > 1) {
            Knoten next = head;
            for (int i = 0; i < size; i++) {
                if (next.getValue().equals(o)) {
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
        for (E e : c) {
            add(e);
        }
        return true;
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            Knoten toString = new Knoten(get(i));

            sb.append(toString.getValue() + "\n");

        }
        return sb.toString();
    }

}
