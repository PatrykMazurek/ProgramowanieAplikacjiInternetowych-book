# Dziedziczenie

### Teoria

Rozdział 5 - Podstawowe elementy języka Java

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

