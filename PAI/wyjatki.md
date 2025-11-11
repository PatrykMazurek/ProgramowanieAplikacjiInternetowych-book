# Wyjątki

### Teoria

Rozdział 11 - Cay S. Horstmann, Gary Cornell, Java Podstawy

### Wyjątki

Wyjątki to mechanizm pozwalający na przechwytywanie błędów w trakcie programu. Zastosowanie wyjątków pozwala na obsłużenie problemów, które mogłyby spowodować zablokowanie programu.

W środowisku Java wyjątki możemy podzielić na dwa rodzaje:

* **Errors** - błędy krytyczne JVM (niebsługiwalne)
* **Exception** - wyjątki aplikacyjne:
  * wyjątki niejawne (unchecked) - głównie błędy programistyczne np. NullPointException, IndexOutOfBundsException.
  * wyjątki jawne (checked) - należy je jawnie obsłużyć przy pomocy `try  / chatch` lub `throws` np. IOException, FileNotFoundException

Jeżeli chcemy przechwycić błąd jawnie poniżej przedstawiony jest przykładowy blok przechwytujący błędy.
