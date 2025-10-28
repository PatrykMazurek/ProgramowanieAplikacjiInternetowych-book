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

**Metody domyślne i stałe w interfejsach**

**Metody prywatne**

**Dziedziczenie interfejsów**

### Zadania

1.  Twoim zadaniem jest zaprojektowanie i zaimplementowanie systemu powiadomień, który umożliwia wysyłanie różnych typów komunikatów do użytkowników. W systemie mogą występować różne kanały powiadomień (np. e-mail, SMS, powiadomienia push), które posiadają wspólne cechy, ale różnią się sposobem wysyłania wiadomości. Stwórz interfejs `Notification`, który będzie zawierał deklarację metody `send()`.&#x20;

    Stwórz przykładowe klasy np. `EmailNotification`, `SMSNotification`, `PushNotification` , które będą implementować interfejs Notification. Każda z klas będzie powinna zawierać prywatne pola **recipient, message.** Kazda z klas powinna implementować metodę send() w zależności w jaki sposób wysyła wiadomość np. `EmailNotification` w metodzie `send()` powinna wyświetlać w konsoli „Wysłano e-mail do \<recipient> : \<message>”.
2. Zadanie 1 z części Dziedziczenie proszę przerobić wykorzystując interfejsy i stwórz kilka klas, które będą reprezentować zwierzęta, w każdej klasie implementuj wymagane metody w sposób odpowiedni dla danej klasy.
3.  Stwórz system opisujący pojady, które mogą pełnić różne funkcje. Stwórz następujące interfejsy:

    `LandVehicle` zawierający metody: **void driveForward(double speed), void applyBrakes()**

    `WaterVehicle` zawierający metody: **void navigateOnWater(double headingDeg, double speed),  void anchor(), void removeAnchor()**

    `AirVehicle` zawierający metody: **void takeOff(), void land().**

    Stwórz dwie klasy `AmphibousVehicle` i `FlyingCar`, które będą implementować odpowiednie interfejsy.  Dodatkowo klasa `AmphibousVehicle` powinna zawierać metody **void switchToWaterMode(), void switchToLandMode()** a klasa `FlyingCar` powinna zawierać metody **void switchToDriveMode(), void switchToFlightMode()**. W klasach `AmphibousVehicle` i `FlyingCar` stwórz konstruktor i niezbędne pola (jeżeli są wymagane).
4. Bazując na zadaniu 3 dodaj dodatkowe interfejsy  `Vehicle`, `AmphibousVehicle` i `FlyingCar`.  Interfejs `Vehicle` zawiera metody: **void start(), void stop(), double getSpeed(), double getFulLevel()**. Interfejsy `AmphibousVehicle` i `FlyingVehicle` powinny zawierać metody, które zostały zdefiniowane w klasie. Stwórz odpowiednią hierarchie interfejsów, tak aby w klasie implementować jak najmniej interfejsów. Przetestuj rozwiązania tworząc klasy np. Car, Bus, Ship, airpalne, Amphibian. Klasy powinny zawierać niezbędne pola i metody z interfejsów.
5.

