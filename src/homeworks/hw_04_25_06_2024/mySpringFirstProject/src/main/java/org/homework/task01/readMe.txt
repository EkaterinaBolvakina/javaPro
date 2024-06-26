### Aufgabe 1: XML-Konfiguration in Spring

**Aufgabe**: Erstellen Sie eine Spring-Anwendung, in der Sie mithilfe der XML-Konfiguration Bins für einen Dienst und ein Repository definieren. Der Dienst muss das Repository verwenden, um Daten abzurufen.

1. **Repository**: Erstellen Sie eine Klasse `MessageRepository` mit einer Methode `getMessage()`, die den String "Hello, Spring!" zurückgibt.
2. **Dienst**: Erstellen Sie eine Klasse `MessageService` mit einer Abhängigkeit von `MessageRepository` und einer Methode `printMessage()`, die eine Nachricht aus dem Repository ausgibt.
3. **XML-Konfiguration**: Definieren Sie die Bins für beide Klassen in der Datei `applicationContext.xml`.
4. **Testen**: Schreiben Sie eine Klasse mit einer `main`-Methode, die einen Spring-Kontext aus XML lädt und `printMessage()` aufruft, um die Nachricht auszugeben.

------------------------- RU --------------------------
### Задача 1: XML-конфигурация в Spring

**Задача**: Создайте приложение Spring, в котором вы определите бины для сервиса и репозитория, используя XML-конфигурацию. Сервис должен использовать репозиторий для получения данных.

1. **Репозиторий**: Создайте класс `MessageRepository` с методом `getMessage()`, который возвращает строку "Hello, Spring!".
2. **Сервис**: Создайте класс `MessageService` с зависимостью от `MessageRepository` и методом `printMessage()`, который выводит сообщение из репозитория.
3. **XML-конфигурация**: Определите бины для обоих классов в файле `applicationContext.xml`.
4. **Тестирование**: Напишите класс с методом `main`, который загружает контекст Spring из XML и вызывает `printMessage()` для вывода сообщения.
