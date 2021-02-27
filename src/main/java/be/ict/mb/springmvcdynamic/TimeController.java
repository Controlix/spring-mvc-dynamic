package be.ict.mb.springmvcdynamic;

import lombok.Value;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    public TimeMessage showTime() {
        return TimeMessage.now();
    }

    @Value
    private static class TimeMessage {
        String time;

        static TimeMessage now() {
            return new TimeMessage(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }
}
