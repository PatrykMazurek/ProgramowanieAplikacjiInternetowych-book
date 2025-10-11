//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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