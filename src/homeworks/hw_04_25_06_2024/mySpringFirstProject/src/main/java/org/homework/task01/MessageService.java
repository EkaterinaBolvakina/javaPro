package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task01;

public class MessageService {
    private MessageRepository messageRepository;

    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void printMessage() {
        System.out.println(messageRepository.getMessage());
    }

}
