package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimePrinter {
    private final TimeService timeService;

    @Autowired
    public TimePrinter(TimeService timeService) {
        this.timeService = timeService;
    }
    public void printTime() {
        System.out.println(timeService.getCurrentTime());
    }
}
