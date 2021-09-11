package Lesson4;

import java.util.*;

public class Phone
{
    private Map<Integer, String> phonebook;
    Phone()
    {
        phonebook = new HashMap<>();
    }

    public void add(int number, String surname)
    {
        phonebook.put(number, surname);
    }

    public void get(String surname)
    {
        if(phonebook.containsValue(surname))
        {
            Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
            for (Map.Entry<Integer, String> temp : set)
            {
                if(temp.getValue().equals(surname))
                {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        }
        else
        {
            System.out.println("Такого имени нет в списке.");
        }
    }
}
