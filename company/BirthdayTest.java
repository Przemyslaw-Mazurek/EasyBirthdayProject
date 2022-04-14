package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class BirthdayTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean wrongData = true;

        System.out.println("Dzień dobry!\nWitam w programie gdzie podamy twoją datę narodzin!\n" +
                "Tylko prosimy w pierwszej kolejności o podanie kilku informacji.");

        do {

            try {
                System.out.println("Podaj rok narodzin!");
                int year = Integer.parseInt(bufferedReader.readLine());
                Validator.validateYear(year);

                System.out.println("Następnie podaj miesiąc !");
                int month = Integer.parseInt(bufferedReader.readLine());
                Validator.validateMonth(month);

                System.out.println("A na sam koniec prosimy o dzień miesiąca twoich narodzin.");
                int dayOfMonth = Integer.parseInt(bufferedReader.readLine());
                Validator.validateDayOfMonth(dayOfMonth);

                Validator.validate(year, month, dayOfMonth);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month-1);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date birthDate = calendar.getTime();
                System.out.printf("Twoja data narodzin to: %1$td %1$tB %1$tY roku.",birthDate);

                wrongData = false;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Nie wprowadziłeś liczby!\nWprowadź dane ponownie.");
            }catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }

        }while (wrongData);
    }
}
