package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      //  UserRepository userRepository = (UserRepository) context.getBean("UserRepository");
        UserService userService = context.getBean(UserService.class);

        userService.printUserGreeting();
    }
}
