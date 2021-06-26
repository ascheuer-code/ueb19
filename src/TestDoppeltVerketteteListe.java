import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class TestDoppeltVerketteteListe {

    @Test
    void testAdd() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();

        assertEquals(true, liste.add("Affe"));
        assertEquals(true, liste.add("Maultier"));
        assertEquals(true, liste.add("Esel"));
        assertEquals(true, liste.add("Loewe"));
    }

    @Test
    void testClear() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        liste.clear();
        assertEquals(0, liste.size());
    }

    @Test
    void testContains() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        assertEquals(true, liste.contains("Affe"));
        assertEquals(true, liste.contains("Maultier"));
        assertEquals(true, liste.contains("Esel"));
        assertEquals(true, liste.contains("Loewe"));

    }

    @Test
    void testContainsAll() {

    }

    @Test
    void testGet() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        Object a = liste.get(0);
        Object b = liste.get(1);
        Object c = liste.get(2);
        Object d = liste.get(3);

        assertEquals("Affe", a.toString());
        assertEquals("Maultier", b.toString());
        assertEquals("Esel", c.toString());
        assertEquals("Loewe", d.toString());
    }

    @Test
    void testRemove() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        assertEquals(true, liste.remove("Maultier"));
        assertEquals(3, liste.getSize());
        assertEquals("Affe\nEsel\nLoewe\n", liste.toString());

    }

    @Test
    void testSet() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        liste.set(2, "Birne");

        assertEquals("Affe\nMaultier\nBirne\nLoewe\n", liste.toString());

    }

    @Test
    void testToArray() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        Object[] newArray = liste.toArray(Object[]::new);
        for (Object object : newArray) {
            System.out.println(object);
        }

    }

    @Test
    void testIndexOF() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        liste.add("Affe");
        liste.add("Maultier");
        liste.add("Esel");
        liste.add("Loewe");

        assertEquals(0, liste.indexOf("Affe"));
        assertEquals(1, liste.indexOf("Maultier"));
        assertEquals(2, liste.indexOf("Esel"));
        assertEquals(3, liste.indexOf("Loewe"));
    }

    @Test
    void testAddAll() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();
        Collection<String> menu1 = new ArrayList<>();

        menu1.add("Get Size of List");
        menu1.add("Check if List is Empty");
        menu1.add("Contains");
        menu1.add("To Array");

        liste.addAll(menu1);

        assertEquals("Get Size of List\nCheck if List is Empty\nContains\nTo Array\n", liste.toString());
    }

}
