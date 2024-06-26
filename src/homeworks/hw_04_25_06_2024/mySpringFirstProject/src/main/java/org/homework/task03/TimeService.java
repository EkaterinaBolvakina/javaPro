package homeworks.hw_04_25_06_2024.mySpringFirstProject.src.main.java.org.homework.task03;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimeService {

    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
