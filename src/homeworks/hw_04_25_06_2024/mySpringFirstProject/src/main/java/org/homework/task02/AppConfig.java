package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("UserRepository")
    public UserRepository getUserRepository() {return new UserRepository();}

    @Bean
    public UserService getUserService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
