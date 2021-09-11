package Lesson4;

import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String[] words = {"Hello", "Word", "Hi", "Hello", "Car", "Boy", "Girl", "Hi", "Car", "Mom"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        System.out.println("==================================");

        Phone phonebook = new Phone();

        phonebook.add(899924650, "Иванов");
        phonebook.add(123456789, "Петров");
        phonebook.add(654345678, "Сидоров");
        phonebook.add(312349876, "Иванов");
        phonebook.add(987678766, "Петров");
        phonebook.add(565656565, "Петров");

        phonebook.get("Иванов");
        phonebook.get("Петров");
        phonebook.get("Сидоров");
        phonebook.get("Конюховский");
    }
}
