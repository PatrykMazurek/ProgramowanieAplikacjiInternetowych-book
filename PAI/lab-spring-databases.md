# spring JPA

### Bazy danych

Framework Spring pozwala na korzystanie z różnych typów baz danych (SQL, NoSQL). Dostęp do bazy danych należy zacząć od zdefiniowania odpowiednich bibliotek, któe mają korzystać z wybranych baz danych.

### Spring JPA

**Wymagane biblioteki**

* Spring Data JPA
* MySql Driver

Po dodaniu wymaganych bibliotek należy uzupełnić plik `application.properties` lub `application.yaml`

**Konfiguracja połączenia**

```
spring.datasource.url = jdbc:mysql://localhost:3306/usersDB?useSSL=false
spring.datasource.username = root
spring.datasource.password = root

# Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

Powyżej przedstawiono konfigurację połączenia z bazą danych i konfigurację hibernate

**Model danych**

```java
import jakarta.persistence.*;

@Entity
@Table(name = "Person" )
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", length = 180)
    private String firstName;
    @Column(name = "last_name", length = 180)
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "city", length = 50)
    private String city;
}
```

W powyższym przykładzie stworzono model, który będzie automatycznie migrowany do bazy danych i na podstawie danego modelu stworzona zostanie tabel w bazie danych.

**Repozytorium**

```java
import com.example.database_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
```

Spring JPA automatycznie generuje podstawowe pytania, które odpowiadają za zapisywanie, odczytywanie, aktualizacja i usuwanie danych z bazy danych, bazując na obiektach

Spring JPA pozwala na pisanie niestandardowych zapytań do bazy danych w zależności od złożoności.

**Query Method -** Spring JPA Automatycznie tworzy zapytania na podstawie nazwy metod zdefiniowanych w interfejsie

```java
import com.example.database_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // find all person by city
    List<Person> findByCity(String city);
    // find all person ny name and city
    List<Person> findByNameAndCity(String name, String city);
}
```

**JPQL** - to obiektowy języ zapytań działający na encjach i polach obiektów a nie na tabeli w bazie danych

```java
import com.example.database_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // JPQL guery to find person in range age
    @Query("SELECT p FROM Person p WHERE s.age > :lowestAge and p.age < :olderAge")
    List<Person> findBetweenRangeAge(@Param("lowestAge") int lowestAge, 
                                        @Param("olderAge") int olderAge);
}
```

**Native SQL Queries** - Natywne zapytania stworzone ręcznie, pozwalają na optymalizację zapytań lub specyficznych zapytań dla wybranych baz danych.

```java
import com.example.database_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
// native query find person by city
    @Query(value = "SELECT * FROM Person WHERE city LIKE :city", nativeQuery = true)
    List<Person> findByCityNativeQuery(@Param("city") String city);
}
```

**Logika biznesowa**

```java
import com.example.database_example.model.Person;
import com.example.database_example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    
    @Autowired
    PersonRepository repository;
    
    public List<Person> getAllPerson(){
        return repository.findAll();
    }
    
    public Person getPerson(long id){
        return repository.findById(id).orElse(null);
    }
    
    // dalsza logika biznesowa
}
```

W powyższym przykładzie przygotowana został klasa `PersonService`, która odpowiada za logikę działania z obiektami Person na bazie danych. Odwołanie do interfejsu `PersonRepository` pozwala na wykonanie takich operacji na bazie danych jak Create, Read, Update, Delete (CRUD).

Pozostaje tylko wyświetlenie danych pobranych z bazy danych przez udostępnienie Rest API lub wyświetlenie na stronie internetowej.

**Materiały dodatkowe**

{% embed url="https://usbwebserver.yura.mk.ua/#download" %}

{% embed url="https://proteinshaikh.medium.com/common-spring-boot-and-hibernate-annotations-list-343a07894051" %}

{% embed url="https://medium.com/@bshiramagond/jpa-with-spring-boot-a-comprehensive-guide-with-examples-e07da6f3d385" %}

{% embed url="https://www.javaguides.net/p/rest-api-tutorial.html" %}

{% embed url="https://medium.com/@pratik.941/how-spring-jpa-works-and-writing-custom-queries-a3d9e67663bc" %}
