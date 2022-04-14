package com.company;

import java.util.HashMap;
import java.util.Map;

public class Validator {

    public static Map<Integer,String> monthsMap = new HashMap<>();

    static {
        monthsMap.put(0,"Styczeń");
        monthsMap.put(1,"Luty");
        monthsMap.put(2,"Marzec");
        monthsMap.put(3,"Kwiecień");
        monthsMap.put(4,"Maj");
        monthsMap.put(5,"Czerwiec");
        monthsMap.put(6,"Lipiec");
        monthsMap.put(7,"Sierpień");
        monthsMap.put(8,"Wrzesień");
        monthsMap.put(9,"Październik");
        monthsMap.put(10,"Listopad");
        monthsMap.put(11,"Grudzień");

    }


    public static void validate(int year, int month, int dayOfMonth) throws IllegalArgumentException {

        --month;

        switch (month){
            case 1:
                if (dayOfMonth>29){
                    throw new IllegalArgumentException(monthsMap.get(month) + " nie może mieć więcej niż 29 dni.\n");
                }
                if (dayOfMonth==29 && year%4!=0){
                    throw new IllegalArgumentException(monthsMap.get(month) + " nie może mieć 29 dni w roku nieprzestępnym.\n");
                }
                if (dayOfMonth==28 && year%4==0){
                    throw new IllegalArgumentException(monthsMap.get(month) + " nie może mieć 28 dni w roku przestępnym.\n");
                }
                break;
            case 3: case 5: case 8: case 10:
                if (dayOfMonth>30) {
                    throw new IllegalArgumentException(monthsMap.get(month) + " nie może mieć więcej niż 30 dni.\n");
                }
                break;

        }

    }

    public static void validateYear(int year) throws IllegalArgumentException{
        if (year<1910 || year>2020)
            throw new IllegalArgumentException("Nie mogłeś się urodzić przed 1910 rokiem ani po 2020!\n");
    }

    public static void validateMonth(int month) throws IllegalArgumentException{
        if (month<1 || month>12)
            throw new IllegalArgumentException("Podałeś zły miesiąc!\n");
    }

    public static void validateDayOfMonth(int dayOfMonth) throws IllegalArgumentException{
        if (dayOfMonth<1 || dayOfMonth>31)
            throw new IllegalArgumentException("Nie może dzień w miesiącu występować poza zakresem 1 - 31\n");
    }
}
