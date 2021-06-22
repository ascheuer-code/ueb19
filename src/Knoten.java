public class Knoten<E> {

    /**
     * Knoten einer doppelt verketteten Liste.
     */

    // Wert des Knotens
    private int value;

    // Vorheriger Knoten
    private E prev;

    // Nächster Knoten
    private E next;

    public void setValue(int v) {
        value = v;
    }

    public void setPrev(E p) {
        prev = p;
    }

    public void setNext(E n) {
        next = n;
    }

    public int getValue() {
        return value;
    }

    public Knoten<E> getPrev() {
        return (Knoten<E>) prev;
    }

    public Knoten<E> getNext() {
        return (Knoten<E>) next;
    }

    // Kopf der Liste
    private Knoten<E> head;

    // Schwanz der Liste
    private Knoten<E> tail;

    public Knoten<E> getHead() {
        return head;
    }

    public void setHead(E head) {
        this.head = (Knoten<E>) head;
    }

    public Knoten<E> getTail() {
        return tail;
    }

    public void setTail(E tail) {
        this.tail = (Knoten<E>) tail;
    }

    // Größe der Liste
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Füge den Wert k am Anfang der Liste ein.
     *
     * @param k Einzufügender Wert
     */
    public void insertFirst(int k) {
        // Neuen Knoten anlegen
        Knoten<E> Knoten = new Knoten<E>();
        Knoten.setValue(k);
        // Ist die Liste noch leer?
        if (head == null) {
            head = Knoten;
            tail = Knoten;
        } else {
            Knoten.setNext(head);
            head.setPrev(Knoten);
            head = Knoten;
        }
        size++;
    }

    /**
     * Füge den Wert k am Ende der Liste ein.
     *
     * @param k Einzufügender Wert
     */
    public void insertLast(int k) {
        // Neuen Knoten anlegen
        Knoten Knoten = new Knoten();
        Knoten.setValue(k);
        // Ist die Liste noch leer?
        if (head == null) {
            head = Knoten;
            tail = Knoten;
        } else {
            Knoten.setPrev(tail);
            tail.setNext(Knoten);
            tail = Knoten;
        }
        size++;
    }

    /**
     * Füge den Wert k in die Liste ein.
     *
     * @param k Einzufügender Wert
     */
    public void insert(int k) {
        insertFirst(k);
    }

    /**
     * Lösche den ersten Wert in der Liste.
     *
     * @return Gelöschter Wert
     */
    public int deleteFirst() {
        int k = 0;
        if (head != null) {
            k = head.getValue();
            // Besteht die Liste nur aus einem Wert?
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Knoten newHead = head.getNext();
                head.setNext(null);
                newHead.setPrev(null);
                head = newHead;
            }
        }
        size--;
        return k;
    }

    /**
     * Löschen den letzten Wert in der Liste.
     *
     * @return Gelöschter Wert
     */
    public int deleteLast() {
        int k = 0;
        if (tail != null) {
            k = tail.getValue();
            // Besteht die Liste nur aus einem Wert?
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Knoten newTail = tail.getPrev();
                tail.setPrev(null);
                newTail.setNext(null);
                tail = newTail;
            }
        }
        size--;
        return k;
    }

    /**
     * Lösche ein Vorkommen des Werts k in der Liste.
     *
     * @param k Zu löschender Wert
     * @return Wurde ein Wert gelöscht?
     */
    public boolean delete(int k) {
        boolean found = false;
        if (head != null) {
            Knoten cur = head;
            while (cur != null && cur.getValue() != k) {
                cur = cur.getNext();
            }
            if (cur != null) {
                found = true;
                Knoten prev = cur.getPrev();
                Knoten next = cur.getNext();
                if (prev != null) {
                    prev.setNext(next);
                } else {
                    head = next;
                }
                if (next != null) {
                    next.setPrev(prev);
                } else {
                    tail = prev;
                }
                cur.setPrev(null);
                cur.setNext(null);
            }
        }
        size--;
        return found;
    }

    /**
     * Suche in einfach verketter Liste.
     *
     * @param k Zu suchender Wert
     * @return Ist der Wert in der Liste enthalten?
     */
    public boolean search(int k) {
        boolean found = false;
        if (head != null) {
            Knoten cur = head;
            while (cur != null && cur.getValue() != k) {
                cur = cur.getNext();
            }
            if (cur != null) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Stelle fest, ob die Liste leer ist.
     *
     * @return Ist die Liste leer?
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Bestimme Anzahl der in der Liste enthaltenen Werte.
     *
     * @return Größe der Liste
     */
    public int size() {
        int size = 0;
        Knoten cur = head;
        while (cur != null) {
            size++;
            cur = cur.getNext();
        }
        return size;
    }

    /**
     * Repräsentation der Liste als Zeichenkette.
     *
     * @return Liste als Zeichenkette
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Knoten cur = head;
        while (cur != null) {
            sb.append(cur.getValue());
            if (cur.getNext() != null) {
                sb.append(" <-> ");
            }
            cur = cur.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

}
