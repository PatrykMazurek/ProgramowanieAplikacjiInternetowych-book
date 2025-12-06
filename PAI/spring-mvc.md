# Spring MVC

MVC (Model-View-Controller). To wzorzec, który informuje nas, jak podzielić aplikację na trzy osobne części, tak aby aplikacja była łatwo modyfikowalna. Zaletą zastosowania wzorca MVC jest jego oddzielność, do widoku możemy zastosować zupełnie inną technologię niż zastosowana została w modelu czy kontrolerze.

Na początek, ważne jest aby dodać dopowiednie zależności.

* Spring Web (do obsługi MVC).
* Thymeleaf (silnik szablonów do wyświetlania HTML).
* Lombok (żeby nie pisać zbędnego kodu).

Przykład kodu z pliku pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

**Model**

Na początek załóżmy pewien model na którym będziemy pracować&#x20;

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private int age;
}
```

**Controller**

Kontroler w naszym projekcie odpowiada za tłumaczenie żądań HTTP na odpowiednie kod wykonawczy. Stwórzmy klasę `PersonController`, która powinna mieć podobny wygląd

```java
import com.example.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    // Symulacja bazy danych w liście
    private List<Person> people = new ArrayList<>();

    public PersonController() {
        people.add(new Person("Jan", "Kowalski", "Warszawa", 30));
        people.add(new Person("Anna", "Nowak", "Kraków", 25));
    }

    // 1. Wyświetlanie listy osób
    @GetMapping("/people")
    public String getPeople(Model model) {
        model.addAttribute("peopleList", people);
        return "people-list"; // szuka pliku people-list.html
    }

    // 2. Formularz dodawania nowej osoby
    @GetMapping("/people/new")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "person-form"; // szuka pliku person-form.html
    }

    // 3. Odbieranie danych z formularza
    @PostMapping("/people")
    public String addPerson(@ModelAttribute Person person) {
        people.add(person);
        return "redirect:/people"; // przekierowanie z powrotem do listy
    }
}
```

Powyższy przykład bazuje na statycznej liście, ale lepszym rozwiązanie jest wykorzystanie bazy danych do przechowywania najważniejszych informacji.&#x20;

Na początek warto dodać adnotację `@Controller` tak aby środowiskowa wiedziało gdzie ma szukać odpowiednich metod na zadane żądanie. Adnotacja `@GetMapping` czy `@PostMapping` odnoszą się do żądań GET\POST HTTP. Każda z metod zwraca String, którym jest nazwa plik html zawierającego widok do wybranej akcji.

**View**

Widok odpowiada za część prezentacyjną w naszym projekcie, w przypadku aplikacji Spring Boot   pliki z widokiem domyślnie powinny znajdować się w katalogu resources\templates&#x20;

