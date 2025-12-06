# Spring Boot

Spring Boot to framework dla Javy, który upraszcza budowanie aplikacji webowych i usług REST. Daje gotowe „startery” zależności, auto-konfigurację i wbudowane serwery (Tomcat/Jetty), więc nie musisz ręcznie sklejać setek bibliotek ani stawiać osobno kontenera aplikacyjnego. Korzysta z konwencji ponad konfigurację: dodajesz odpowiedni starter (np. web, data-jpa, security), piszesz kilka klas z adnotacjami (@RestController, @Service, @Entity), a resztę robi za Ciebie. Do tego dochodzą profile środowiskowe, pliki `application.properties`/`application.yml`, Actuator do monitoringu oraz świetna integracja z Mavenem/Gradle.

Typowy workflow studenta: generujesz projekt (np. Spring Initializr), odpalasz `mvn spring-boot:run` albo `gradle bootRun`, a potem tworzysz warstwy Controller-Service-Repository i wystawiasz endpointy REST. Na start często używa się wbudowanej bazy H2, a później przechodzi na Postgresa/MySQL; dane mapujesz JPA/Hibernate’em, a testy piszesz z Spring Boot Test i MockMvc. DevTools przyspiesza przeładowywanie kodu, Actuator odsłania metryki/health, a pakowanie do JAR z wbudowanym serwerem ułatwia wdrożenia na chmurę. W praktyce największym „minusem” bywa magia auto-konfiguracji—gdy coś nie działa, patrz w logi przy starcie i dokumentację starterów, bo tam zwykle kryje się odpowiedź.

Tworzenie projektu możemy zacząć na kilka sposbów:

* Przez stronę internetową (możliwość pobrania wybranych rozszerzeń)

{% embed url="https://start.spring.io/" %}

* Przez rozszerzenia dostępne w środowiskach tj. intellj czy VSCode
