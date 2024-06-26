package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
      // direkt: // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.homework.task03");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TimePrinter timePrinter = context.getBean(TimePrinter.class);
        timePrinter.printTime();
        context.close();
    }
}
