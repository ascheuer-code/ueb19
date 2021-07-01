## 1. Aufgabe
In der Vorlesung Informatik 2 haben Sie die Datenstruktur einer doppelt verketteten Liste kennen
gelernt. Implementieren Sie diese Datenstruktur in Java. Beachten Sie dabei Folgendes:

(a) Implementieren Sie das Interface java.util.List<E> 1 des Java Collections Frameworks, in
dem Sie eine Klasse mit dem Namen DoppeltVerketteteListe<E> implements List<E>
programmieren. Sie müssen jedoch nur die folgenden Methoden des Interfaces implementieren. Für alle anderen können Sie eine java.lang.UnsupportedOperationException werfen.
  
```
i public int size()
ii public boolean isEmpty()
iii public boolean contains(Object o)
iv public <T> T[] toArray(T[] a)
v public boolean add(E e)
vi public boolean remove(Object o)
vii public boolean addAll(Collection<? extends E> c)
viii public void clear()
ix public E get(int index)
x public E set(int index, E element)
xi public void add(int index, E element)
xii public E remove(int index)
xiii public int indexOf(Object o)
```
(b) Verwenden Sie nicht die abstrakte Klasse java.util.AbstractList<E>.

(c) Implementieren Sie die doppelt verkettete Liste als generische Klasse.

(d) Implementieren Sie eine Dialogklasse, welche alle Operationen Ihrer Liste testet.

## 2. Aufgabe (Zusatzaufgabe)
Implementieren Sie für Ihre verkettete Liste in Aufgabe 1 auch folgende Methoden

i public ListIterator<E> listIterator(int index)

ii public Iterator<E> iterator()

Hinweis: Sie müssen Klassen implementieren, welche das Interface java.util.Iterator<E>
bzw. java.util.ListIterator<E> implementieren.
