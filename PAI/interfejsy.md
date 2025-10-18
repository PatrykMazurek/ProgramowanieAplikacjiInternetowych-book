# Interfejsy

### Teoria

Rozdział 6 - Cay S. Horstmann, Gary Cornell, Java Podstawy

### Interfejsy

W języku Java interfejsy nie są klasą, ale zestawem wymagań co klasa implementująca dany interfejs powinna zawierać. Interfejsy zawierają definicję metody ale bez jej implementacji. to jak zostanie ona zaimplementowana powstawiają klasie.&#x20;

Interfejsy zawsze są publiczne, więc nie wymagane jest dodawanie słówka public przed nazwą metody, w interfejsie może być zdefiniowana jedna lub więcej metod, czasami spotykana jest deklaracja stałej.&#x20;

Klasa może implementować wiele interfejsów, co pozwala na pisanie bardziej elastycznego kodu. Przykład implementacji interfejsu.

```java
public interface Animal {
    
    void voice();
    
}
```

implementacja w klasie

```java
public class Cat implements Animal{
    @Override
    public void voice() {
        System.out.println("Mau!");
    }
}

public class Dog implements Animal{
    @Override
    public void voice() {
        System.out.println("Hu! Hu!");
    }
}

```

W powyższym przykładzie przedstawiono sposób implementacji interfejsu w klasie. Aby implementować wybrany interfejs należy po nazwie klasy dodać słówko `implements` i  podać nazwę wybranego interfejsu.&#x20;



