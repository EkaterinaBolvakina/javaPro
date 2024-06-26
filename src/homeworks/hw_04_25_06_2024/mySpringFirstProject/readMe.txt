Homework 04: Thema: 3 Methoden zur Konfiguration in SPRING:
## 1.
### Aufgabe 1: XML-Konfiguration in Spring

**Aufgabe**: Erstellen Sie eine Spring-Anwendung, in der Sie mithilfe der XML-Konfiguration Bins für einen Dienst und ein Repository definieren. Der Dienst muss das Repository verwenden, um Daten abzurufen.

1. **Repository**: Erstellen Sie eine Klasse `MessageRepository` mit einer Methode `getMessage()`, die den String "Hello, Spring!" zurückgibt.
2. **Dienst**: Erstellen Sie eine Klasse `MessageService` mit einer Abhängigkeit von `MessageRepository` und einer Methode `printMessage()`, die eine Nachricht aus dem Repository ausgibt.
3. **XML-Konfiguration**: Definieren Sie die Bins für beide Klassen in der Datei `applicationContext.xml`.
4. **Testen**: Schreiben Sie eine Klasse mit einer `main`-Methode, die den Spring-Kontext aus XML lädt und `printMessage()` aufruft, um die Nachricht auszugeben.

### Aufgabe 2: Java-Konfiguration in Spring

**Aufgabe**: Erstellen Sie eine Java-Konfigurationsklasse für Spring, die Bins für Service- und Repository-Komponenten konfiguriert. Der Dienst sollte das Repository über einen Konstruktor injizieren und eine Methode zur Ausgabe der Informationen bereitstellen.

1. **Repository**: Erstellen Sie eine "UserRepository"-Klasse mit einer "getUserName()"-Methode, die den Benutzernamen zurückgibt.
2. **Dienst**: Erstellen Sie eine Klasse `UserService`, die `UserRepository` verwendet, um den Benutzernamen zu erhalten und eine Begrüßung mit diesem Namen anzuzeigen.
3. **Konfiguration**: Erstellen Sie eine `AppConfig` Klasse mit der Annotation `@Configuration`, in der Sie Methoden mit der Annotation `@Bean` definieren, um Service und Repository Bins zu erstellen.
4. **Testing**: Erstellen Sie eine Klasse mit einer `main`-Methode, die den Spring-Kontext aus `AppConfig` lädt und den Service zur Ausgabe einer Willkommensnachricht verwendet.

#### Aufgabe 3: Annotationen in Spring für eine Konsolenanwendung

**Aufgabe**: Erstellen Sie eine Konsolenanwendung in Spring, die Annotationen für die Konfiguration verwendet. Die Anwendung soll die vom Service empfangene aktuelle Zeit auf der Konsole ausgeben.

1. **Dienst**: Entwickeln Sie eine `TimeService` Klasse mit einer `getCurrentTime()` Methode, die einen formatierten String mit der aktuellen Zeit zurückgibt.

2. **Ausgabekomponente**: Erstellen Sie eine `TimePrinter` Klasse, die `TimeService` benutzt, um die aktuelle Zeit zu erhalten und sie auf der Konsole auszugeben.

3. **Anmerkungen**: Benutzen Sie `@Component`, um `TimeService` und `@Component` für `TimePrinter` zu annotieren. `@Autowired` wird verwendet, um `TimeService` in `TimePrinter` zu injizieren.

4. **Konfiguration**: Erstellen Sie eine Konfigurationsklasse mit `@Configuration`, die das Scannen von Komponenten beinhaltet, um Bins automatisch zu erkennen und zu erstellen.

5. **Testen**: In der Methode `main` laden Sie den Spring-Kontext und verwenden `TimePrinter`, um die aktuelle Zeit auf der Konsole auszugeben.

------------------- RU ------------------------
## 1.
### Задача 1: XML-конфигурация в Spring

**Задача**: Создайте приложение Spring, в котором вы определите бины для сервиса и репозитория, используя XML-конфигурацию. Сервис должен использовать репозиторий для получения данных.

1. **Репозиторий**: Создайте класс `MessageRepository` с методом `getMessage()`, который возвращает строку "Hello, Spring!".
2. **Сервис**: Создайте класс `MessageService` с зависимостью от `MessageRepository` и методом `printMessage()`, который выводит сообщение из репозитория.
3. **XML-конфигурация**: Определите бины для обоих классов в файле `applicationContext.xml`.
4. **Тестирование**: Напишите класс с методом `main`, который загружает контекст Spring из XML и вызывает `printMessage()` для вывода сообщения.

### Задача 2: Java-конфигурация в Spring

**Задача**: Создайте конфигурационный класс Java для Spring, который конфигурирует бины для компонентов сервиса и репозитория. Сервис должен инжектить репозиторий через конструктор и предоставлять метод для вывода информации.

1. **Репозиторий**: Создайте класс `UserRepository` с методом `getUserName()`, возвращающим имя пользователя.
2. **Сервис**: Создайте класс `UserService`, который использует `UserRepository` для получения имени пользователя и выводит приветствие с этим именем.
3. **Конфигурация**: Создайте класс `AppConfig` с аннотацией `@Configuration`, в котором вы определите методы с аннотацией `@Bean` для создания бинов сервиса и репозитория.
4. **Тестирование**: Создайте класс с методом `main`, который загружает контекст Spring из `AppConfig` и использует сервис для вывода приветствия.

### Задача 3: Аннотации в Spring для консольного приложения

**Задача**: Создайте консольное приложение на Spring, которое использует аннотации для конфигурации. Приложение должно выводить в консоль текущее время, полученное из сервиса.

1. **Сервис**: Разработайте класс `TimeService` с методом `getCurrentTime()`, который возвращает отформатированную строку с текущим временем.

2. **Компонент для вывода**: Создайте класс `TimePrinter`, который будет использовать `TimeService` для получения текущего времени и его вывода в консоль.

3. **Аннотации**: Используйте `@Component` для аннотирования `TimeService` и `@Component` для `TimePrinter`. `@Autowired` используется для инъекции `TimeService` в `TimePrinter`.

4. **Конфигурация**: Создайте класс конфигурации с `@Configuration`, который включает сканирование компонентов для автоматического обнаружения и создания бинов.

5. **Тестирование**: В методе `main` загрузите контекст Spring и используйте `TimePrinter` для вывода текущего времени в консоль.