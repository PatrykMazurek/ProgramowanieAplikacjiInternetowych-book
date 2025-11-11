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

Więcej dostępnych metod można znaleźć w dokumntacji&#x20;

{% embed url="https://docs.oracle.com/javase/8/docs/api/java/util/List.html" %}

### Kolekcje Map



### Kolekcje Set



### Zadania



### Materiały dodatkowe
