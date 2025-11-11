# Kolekcje

### Kolekcje List

List - uporządkowana kolekcja, która pozwala zachować kontrole nad elementami, Dostęp do elementu na podstawie indeksu. interfejs List dziedziczy po interfejsie Collection. Najpopularniejsze obiekty List:

* ArrayList
* LinkedList
* Vector

Przykłady zastosowań:

```java
List<String> animal = new ArrayList<>();
animal.add("słoń");
animal.add("lew");
animal.add("pingwin");
animal.addFirst("tygrys");
if (animal.remove("krokodyl")){
    System.out.println("usunięto z listy");
}else{
    System.out.println("nie ma obiektu na liście");
}
String removeObj = animal.remove(1);
String obj1 = animal.get(0);
String obj2 = animal.getLast();
int idx = animal.indexOf("lew");
if (idx != -1) {
    System.out.println("obiekt jest na liście");
}else {
    System.out.println("obiektu nie ma na liście");
}
```

Więcej dostępnych metod można znaleźć w dokumentacji&#x20;

{% embed url="https://docs.oracle.com/javase/8/docs/api/java/util/List.html" %}

### Kolekcje Map

Map - Kołecka

* HashMap
* LinkedHashMap
* TreeMap

Przykład zastosowania&#x20;



Więcej dostępnych metod można znaleźć w dokumntacji&#x20;

{% embed url="https://docs.oracle.com/javase/8/docs/api/java/util/Map.html" %}

### Kolekcje Set

Set - kolekcja nie uporządkowana, w której nie masz kontroli na kolejnością elementów, nie można odwołać się do elementów po indeksie. Set nie pozwala na przechowywanie duplikatów. Interfejs Set dziedziczy po interfejsie Collection. Najpopularniejsze obiekty Set:

* HashSet
* LinkedHashSet
* TreeSet

Przykład zastosowania&#x20;



Więcej dostępnych metod można znaleźć w dokumentacji&#x20;

{% embed url="https://docs.oracle.com/javase/8/docs/api/java/util/Set.html" %}

### Zadania



### Materiały dodatkowe
