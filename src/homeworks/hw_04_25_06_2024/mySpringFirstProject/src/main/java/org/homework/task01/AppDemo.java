package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        //1. Lädt den Spring-Kontext aus der XML-Datei applicationContext.xml:
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. Holt den Bean messageService und ruft die Methode printMessage() auf, um die Nachricht auszugeben:
        MessageService messageService = (MessageService) context.getBean("messageService");
        messageService.printMessage();

        //3. Schließt den Kontext, um Ressourcen freizugeben:
        context.close();
    }
}
