#### Aufgabe 3: Annotationen in Spring für eine Konsolenanwendung

**Aufgabe**: Erstellen Sie eine Konsolenanwendung in Spring, die Annotationen für die Konfiguration verwendet. Die Anwendung soll die vom Dienst empfangene aktuelle Zeit auf der Konsole ausgeben.

1. **Dienst**: Entwickeln Sie eine `TimeService` Klasse mit einer `getCurrentTime()` Methode, die einen formatierten String mit der aktuellen Zeit zurückgibt.

2. **Ausgabekomponente**: Erstellen Sie eine `TimePrinter` Klasse, die `TimeService` benutzt, um die aktuelle Zeit zu erhalten und sie auf der Konsole auszugeben.

3. **Anmerkungen**: Benutzen Sie `@Component`, um `TimeService` und `@Component` für `TimePrinter` zu annotieren. `@Autowired` wird verwendet, um `TimeService` in `TimePrinter` zu injizieren.

4. **Konfiguration**: Erstellen Sie eine Konfigurationsklasse mit `@Configuration`, die das Scannen von Komponenten beinhaltet, um Bins automatisch zu erkennen und zu erstellen.

5. **Testen**: In der Methode `main` laden Sie den Spring-Kontext und verwenden `TimePrinter`, um die aktuelle Zeit auf der Konsole auszugeben.

---------------------------- RU -----------------------------------
### Задача 3: Аннотации в Spring для консольного приложения

**Задача**: Создайте консольное приложение на Spring, которое использует аннотации для конфигурации. Приложение должно выводить в консоль текущее время, полученное из сервиса.

1. **Сервис**: Разработайте класс `TimeService` с методом `getCurrentTime()`, который возвращает отформатированную строку с текущим временем.

2. **Компонент для вывода**: Создайте класс `TimePrinter`, который будет использовать `TimeService` для получения текущего времени и его вывода в консоль.

3. **Аннотации**: Используйте `@Component` для аннотирования `TimeService` и `@Component` для `TimePrinter`. `@Autowired` используется для инъекции `TimeService` в `TimePrinter`.

4. **Конфигурация**: Создайте класс конфигурации с `@Configuration`, который включает сканирование компонентов для автоматического обнаружения и создания бинов.

5. **Тестирование**: В методе `main` загрузите контекст Spring и используйте `TimePrinter` для вывода текущего времени в консоль.