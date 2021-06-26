public class Knoten {

    public Knoten(Object value) {
        this.value = value;
    }

    private Object value;

    private Knoten prev;

    private Knoten next;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Knoten getPrev() {
        return prev;
    }

    public void setPrev(Knoten prev) {
        this.prev = prev;
    }

    public Knoten getNext() {
        return next;
    }

    public void setNext(Knoten next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public boolean hasNext() {
        return (this.getNext() != null) ? true : false;
    }

}