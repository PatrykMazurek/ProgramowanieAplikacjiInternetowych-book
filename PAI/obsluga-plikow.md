# Obsługa plików

Manipulacja plikami jest jednym z podstawowych zagadnienia programowania w Javie. Niezależnie od tego czy chcesz zapisywać dane aplikacji, generować logi, czy obsługiwać zewnętrzne pliki konfiguracyjne. Obsługa plików nie obejdzie się bez wskazania lokalizacji, w której dany plik się znajduje.

W języku Java znajdują się dwa pakiety, za pomocą których można działać na plikach i katalogach:

* `java.io.*` - starsza wersja
* `java.nio.*` - nowsza wersja&#x20;

### Metoda Paths.get()

Metoda `Paths.get()` klasy `java.nio.file.Paths` w języku Java jest podstawowym narzędziem do obsługi ścieżek plików. Pozwala ona tworzyć obiekty `Path`, które mogą być używane do reprezentowania ścieżek plików i katalogów w sposób niezależny od platformy.

```java
Path path = Paths.get("C:", "Users", "Student", "Documents", "file.txt");
```

Metoda może przyjmować jeden lub więcej argumentów typu string. Pierwszy argument jest obowiązkowy i reprezentuje początkową część ścieżki. Wszelkie dodatkowe argumenty są traktowane jako pod ścieżki, które mają zostać dołączone do ścieżki początkowej.

**Ścieżka absolutna vs. relatywna**

Ścieżka bezwzględna to pełna ścieżka od katalogu głównego do docelowego pliku lub katalogu. Rozpoczyna się od katalogu głównego systemu plików i przechodzi przez hierarchię katalogów, aby zlokalizować cel. Ścieżki bezwzględne są jednoznaczne i mogą być używane do jednoznacznej identyfikacji pliku lub katalogu, niezależnie od bieżącego katalogu roboczego aplikacji.

Ścieżka względna określa lokalizację pliku lub katalogu względem innego katalogu, zazwyczaj bieżącego katalogu roboczego. W przeciwieństwie do ścieżek bezwzględnych, ścieżki względne nie zaczynają się od katalogu głównego, ale od katalogu, w którym aktualnie działa aplikacja.

### Klasa File

Klasa File pozwala nam na manipulowanie plikami tworzenie, usuwanie, przenoszenie czy sprawdzanie czy dany plik istniej lub jego prawa dostępu.&#x20;

```java
File file = new File("example.txt");

try {
    if (file.createNewFile()) {
        System.out.println("Plik utworzony: " + file.getName());
    } else {
        System.out.println("Plik już istnieje.");
    }
} catch (IOException e) {
    System.out.println("Wystąpił błąd.");
    e.printStackTrace();
}
```

W powyższym przykładzie próbujemy stworzyć plik w domyślnej lokalizacji,. Jeżeli plik już będzie istniał to nie zostanie utworzony, a jeżeli pliku nie będzie to zostanie stworzony.&#x20;

W sytuacji kiedy potzrbujemy sprawdzić informacje o pliku możemy wykorzystać następujące metody&#x20;

```java
File file = new File("example.txt");
if (file.exists()) {
    System.out.println("Nazwa pliku: " + file.getName());
    System.out.println("Ścieżka absolutna: " + file.getAbsolutePath());
    System.out.println("Czy plik jest zapisywalny: " + file.canWrite());
    System.out.println("Czy plik jest odczytywalny: " + file.canRead());
    System.out.println("Rozmiar pliku: " + file.length() + " bajtów");
}
```



### Odczyt i zapis do pliku



### Zadania





1.
2. Napisz program, który znajduje w podanym katalogu wszystkie pliki większe niż 2048 bajtów i zapisuje listę ich ścieżek do pliku tekstowego `big_files.txt`.
3.
