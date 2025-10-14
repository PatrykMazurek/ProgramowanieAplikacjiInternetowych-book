# Dziedziczenie

### Teoria

Rozdział 5 - Java Podstawy, Cay S. Horstmann

### Dziedziczenie

Dziedziczenie w Javie to mechanizm, który pozwala jednej klasie (podrzędnej) przejmować pola i metody innej klasy (nadrzędnej), dzięki czemu można ponownie wykorzystywać kod. Umożliwia to tworzenie hierarchii klas, gdzie klasy potomne rozszerzają lub modyfikują zachowanie klas bazowych.

Przykład dziedziczenia:

**Klasa Person**

```java
public class Person {
    
    private String name;
    private String lastname;
    private int age;
    
    public Person(String name, String lastname, int age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getLastname() { return lastname; }

    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
}
```

**Klasa Student**

```java
public class Student extends Person{

    private String studentID;

    public Student(String name, String lastname, int age, String id) {
        super(name, lastname, age);
        this.studentID = id;
    }

    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getStudentID() { return studentID; }
}
```

W powyższym przykładzie użyliśmy słówka `extends` aby wskazać że klasa `Student` będzie dziedziczyć wszystkie pola i metody po klasie `Person`. W tej sytuacji nie musimy tworzyć dwóch obiektów tylko wystarczy że stworzymy obiekt `Student` aby mieć dostęp do pół klasy `Person`. Przykład.

W konstruktorze klasy `Student` używane jest słówko `super`, słówko to pozwala na wywołania konstruktorów i metod z nadklasy. Jeżeli słówko jest wywoływane w konstruktorze powinno być jako pierwsze i wywołuje odpowiedni konstruktor (argumentowy lub bezargumentowy).

```java
public class Main {
    public static void main(String[] args) {
        
        // stworzenie obiektu Person
        Person p = new Person("Jak", "Kowalski", 34);
        System.out.println(p.getName());
        
        // stworzenie obiektu Student
        Student s = new Student("Ewa", "Nowak", 23, "p00012");
        System.out.println(s.getName());
        System.out.println(s.getStudentID());
    }
}
```

W powyższym przypadku stworzyliśmy dwa obiekty `Person` i `Student`. Obiekt `Student` przez to że dziedziczy po klasie `Person` ma dostęp do takich metod jak np. `getName()`.&#x20;

### **Nadpisywanie metod (@override)**

W niektórych sytuacja klasa bazowa posiada metodę, którą chcemy nadpisać w klasie pochodnej. w tym celu dla zachowania czystości kodu dopisujemy przed tą metodą słówko `@override`, nie jest to wymagane ale zalecane. Poniżej przykład nadpisywania metod.&#x20;

**Klasa Person**

```java
public class Person {

    private String name;
    private String lastname;
    private int age;

    public Person(String name, String lastname, int age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    // gettery, settery

    public void present(){
        System.out.println("Imię: " + this.name + " " + " Nazwisko: " + this.lastname);
        System.out.println("wiek: " + this.age);
    }
}

```

**Klasa Student**

```java
public class Student  extends Person{

    private String studentID;

    public Student(String name, String lastname, int age, String id) {
        super(name, lastname, age);
        this.studentID = id;
    }

    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getStudentID() { return studentID; }

    @Override
    public  void present(){
        super.present();
        System.out.println("student nr " + this.studentID);
    }
}
```

W powyższym przykładzie w klasie `Person` została zdefiniowana metoda `persent()`, której zadaniem jest przedstawianie się. W klasie `Student` została nadpisana metoda `present()`, w której poza tym że wykorzystujemy metodę z klasy bazowej to dodajemy dodatkową informację o numerze studenta. Aby wykorzystać metody z klasy bazowej musimy w klasie pochodnej zastosować słówko `super` przed wywołaniem metody.&#x20;

### Klasa Abstrakcyjna&#x20;

W języku Java klasy mogą być zwykłe lub abstrakcyjne.\
Klasy abstrakcyjne są szablonami, które nie mogą być bezpośrednio tworzone (instancjonowane), ale mogą zawierać wspólne elementy dla innych klas.

Klasa abstrakcyjna w definicja zawiera słowo kluczowe `abstract`. Taka deklaracja powoduje pewien problem ponieważ taka klasa nie może być utworzona (`new` jest niedozwolone).  Klasa abstrakcyjna może zawierać pola, zwykłe metody ( z implementacją), metody abstrakcyjne (tylko definicja), Każda klasa, która dziedziczy po klasie abstrakcyjnej musi zaimplementować metody abstrakcyjne, chyba że sama jest klasą abstrakcyjną.&#x20;

**Przykład klasy abstrakcyjnej**

```java
public abstract class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
    }

    // metoda zwykła (z implementacją)
    public void introduceYourself() {
        System.out.println("Jestem zwierzęciem o imieniu " + name);
    }

    // metoda abstrakcyjna (bez implementacji)
    public abstract void voice();
}
```

**Dziedziczenie po klasie abstrakcyjnej**

Klasa, która dziedziczy po klasie abstrakcyjnej dodatkowo musi implementować wszystkie metody abstrakcyjne klasy nadrzędnej.

```java
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Hau! Hau!");
    }
}

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Miau!");
    }
}
```

**Przykład użycia**

```java
public class Main {
    public static void main(String[] args) {
        // Animal a = new Animal("Burek"); – nie można tworzyć obiektu klasy abstrakcyjnej!

        Animal dog = new Dog("Reksio");
        Animal cat = new Cat("Filemon");

        dog.introduceYourself();
        dog.voice();

        cat.introduceYourself();
        cat.voice();
    }
}
```

W&#x20;

### Polimorfizm



### Zadania

1. Napisz program pozwalający na rekrutację nowych pracowników (dopisywanie ich do listy) oraz wyświetlanie danych obecnych (wypisywanie z listy)
   * klasą nadrzędną będzie **Employee**, a dziedziczyć po niej będą minimum dwie klasy reprezentujące dwa różne zawody
   * należy zaproponować atrybuty opisujące każdego z nich
   * użytkownik ma możliwość utworzenia nowego pracownika za pomocą inputu z klawiatury oraz wypisania wszystkich już istniejących w bazie
2.

Twoim zadaniem jest zaprojektowanie i zaimplementowanie systemu powiadomień, który umożliwia wysyłanie różnych typów komunikatów do użytkowników. W systemie mogą występować różne kanały powiadomień (np. e-mail, SMS, powiadomienia push), które posiadają wspólne cechy, ale różnią się sposobem wysyłania wiadomości.

Wymagania funkcyjne

Stwórz klasę bazową `Notification`, która będzie zawierać:

Pola:

Recipient - odbiorca wiadomości (np. nr tel, e-mail, identyfikator użytkownika)

Message – treść wiadomości

Konstruktor przyjmujący powyższe pola

Metodę `send()`, która będzie odpowiadać za wysłanie wiadomości.

Stwórz trzy klasy `EmailNotification`, `SMSNotification`, `PushNotification`, które będą dziedziczące po klasie Notification. Każda z klas powinna nadpisywać metodę `send()` w zależności od sposobu wysyłania wiadomości np. `EmailNotification` w metodzie `send()` powinna wyświetlać w konsoli „Wysłano e-mail do \<recipient> : \<message>”.

Stwórz rozwiązanie za pomocą, którego pozwolisz użytkownikowi na wpisanie do kogo wysłać wiadomość wraz z treść oraz sposobu wysłania wiadomości. &#x20;
