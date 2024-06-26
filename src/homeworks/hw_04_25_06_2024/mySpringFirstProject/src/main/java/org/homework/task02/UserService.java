package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task02;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void printUserGreeting() {
        System.out.println("Hello " + userRepository.getUserName() + "! You are welcome here!");
    }

}
