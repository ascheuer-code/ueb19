import static org.junit.jupiter.api.Assertions.assertEquals;

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

        // macht irgendwie keinen sinn grad
    }

}
