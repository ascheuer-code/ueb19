import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dialog extends Lib_Dialog {

    private static Object classObject;
    private static ArrayList<String> menu1;
    private static DoppeltVerketteteListe<Object> liste;

    public static void main(String[] args) {

        new Dialog().start();

        menu1.add("Get Size of List");
        menu1.add("Check if List is Empty");
        menu1.add("Contains");
        menu1.add("To Array");
        menu1.add("Add");
        menu1.add("Remove specific Object");
        menu1.add("Add All from Collection");
        menu1.add("Clear List");
        menu1.add("Get Item from Index");
        menu1.add("Set specific Index new");
        menu1.add("Add at specific Index");
        menu1.add("Remove index in List");
        menu1.add("Get Item of Index");

        classObject = new Dialog();

        new Lib_Dialog().start(menu1, classObject);

    }

    public void start() {
        liste = new DoppeltVerketteteListe<>();

        menu1 = new ArrayList<>();

    }

    public void getSizeOfList() {
        System.out.println("\n" + liste.getSize());
    }

    public void checkIfListIsEmpty() {
        System.out.println("\n" + liste.isEmpty());
    }

    public void contains() {
        System.out.println("\nNach was wollen sie suchen?");
        Object lookingFor = input.next();
        System.out.println(liste.contains(lookingFor));

    }

    public void toArray() {
        Object[] test = liste.toArray();
        for (Object object : test) {
            System.out.println(object.toString());
        }
    }

    public void add() {
        System.out.println("\nWert eingeben:");
        liste.add(input.next());
    }

    public void addAllFromCollection() {
        System.out.println(liste.addAll(menu1));
    }

    public void clearList() {
        liste.clear();
        getSizeOfList();
    }

    public void getItemFromIndex() {
        System.out.println(liste.get(input.nextInt()));
    }

    public void setSpecificIndexNew() {
        System.out.println("\n Index angeben danach Objekt");
        System.out.println(liste.set(input.nextInt(), input.next()));
    }

    // public void addAtSpecificIndex(){
    //
    // }

    public void removeSpecificObject() {
        System.out.println("\nWas soll entfernt werden?");
        System.out.println(liste.remove(input.next()));
    }

    public void getItemOfIndex() {

    }

}
