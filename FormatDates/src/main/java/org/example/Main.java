package org.example;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDateTime  currentTime = LocalDateTime.now();
        DateTimeFormatter formattingDate = DateTimeFormatter.ofPattern("MM/dd/yyy");

        String fullDate = currentTime.format(formattingDate);

        DateTimeFormatter updatedFormat = DateTimeFormatter.ofPattern("yyy-MM-dd");
        String newFormattedDate = currentTime.format(updatedFormat);

        DateTimeFormatter monthInWords = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String monInWords = currentTime.format(monthInWords);

        DateTimeFormatter dayInWeek = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss");
        String dayInWeekWithMonInWords = currentTime.format(dayInWeek);

        //DateTimeFormatter bonusFormat = DateTimeFormatter.ofPattern("");

        System.out.println(fullDate);
        System.out.println(newFormattedDate);
        System.out.println(monInWords);
        System.out.println(dayInWeekWithMonInWords);
    }
}