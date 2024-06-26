### Aufgabe 2: Java-Konfiguration in Spring

**Aufgabe**: Erstellen Sie eine Java-Konfigurationsklasse für Spring, die Bins für Service- und Repository-Komponenten konfiguriert. Der Dienst sollte das Repository über einen Konstruktor injizieren und eine Methode zur Ausgabe der Informationen bereitstellen.

1. **Repository**: Erstellen Sie eine "UserRepository"-Klasse mit einer "getUserName()"-Methode, die den Benutzernamen zurückgibt.
2. **Dienst**: Erstellen Sie eine Klasse `UserService`, die `UserRepository` verwendet, um den Benutzernamen zu erhalten und eine Begrüßung mit diesem Namen anzuzeigen.
3. **Konfiguration**: Erstellen Sie eine `AppConfig` Klasse mit der Annotation `@Configuration`, in der Sie Methoden mit der Annotation `@Bean` definieren, um Service und Repository Bins zu erstellen.
4. **Testing**: Erstellen Sie eine Klasse mit einer `main`-Methode, die den Spring-Kontext aus `AppConfig` lädt und den Service zur Ausgabe einer Willkommensnachricht verwendet.

------------------- RU ---------------------------------
### Задача 2: Java-конфигурация в Spring

**Задача**: Создайте конфигурационный класс Java для Spring, который конфигурирует бины для компонентов сервиса и репозитория. Сервис должен инжектить репозиторий через конструктор и предоставлять метод для вывода информации.

1. **Репозиторий**: Создайте класс `UserRepository` с методом `getUserName()`, возвращающим имя пользователя.
2. **Сервис**: Создайте класс `UserService`, который использует `UserRepository` для получения имени пользователя и выводит приветствие с этим именем.
3. **Конфигурация**: Создайте класс `AppConfig` с аннотацией `@Configuration`, в котором вы определите методы с аннотацией `@Bean` для создания бинов сервиса и репозитория.
4. **Тестирование**: Создайте класс с методом `main`, который загружает контекст Spring из `AppConfig` и использует сервис для вывода приветствия.