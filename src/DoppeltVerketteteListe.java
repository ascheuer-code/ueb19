import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DoppeltVerketteteListe<E> implements List<E> {

    Knoten<E> node = new Knoten<E>();

    @Override
    public int size() {
        return node.getSize();
    }

    @Override
    public boolean isEmpty() {
        return (node.getHead() == null) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        Knoten<E> head = node.getHead();
        Knoten<E> cur = head.getNext();
        if (head == null) {
            return false;
        }
        while (head.getNext() != null && !cur.equals(o)) {
            cur = cur.getNext();
            if (cur.equals(o)) {
                return true;
            }
        }
        return false;

    }

    public <T> T[] toArray(T[] a) {

        // List<T> liste = new ArrayList<>();
        // for (T t : a) {
        // if(t != null){
        // liste.add(t);
        // }
        // }
        // return (T[]) liste.toArray(Object[]::new);
        //

        return (T[]) Arrays.asList().toArray(Object[]::new);
    }

    public boolean add(E e) {
        Knoten<E> head = node.getHead();
        Knoten<E> cur = head.getNext();
        if (node.getHead() == null) {
            node.setHead(e);
            node.setTail(null);
        }
        if (node.getHead() != null && node.getTail() == null) {
            node.setTail(e);
            node.getTail().setPrev((E) head);
        }
        if (node.getHead() != null && node.getTail() != null) {
            cur = node.getTail();
            node.setTail(e);
            cur.setNext((E) node.getTail());
            node.getTail().setPrev((E) cur);
        }

        return true;
    }

    public boolean remove(Object o) {

    }

    public boolean addAll(Collection<? extends E> c) {

    }

    public void clear() {

    }

    public E get(int index) {

    }

    public E set(int index, E element) {

    }

    public void add(int index, E element) {

    }

    public E remove(int index) {

    }

    public int indexOf(Object o) {

    }

}
