package Level2_Lesson_3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Список слов с повторениями
        String[] plant = {"Абрикос", "Агатис", "Агатис", "Айва", "Акация", "Актиностробус", "Алоэ", "Алыча", "Аннона", "Апельсин",
                "Бергамот", "Берёза", "Бирючина", "Боярышник", "Бук", "Венге", "Вирола", "Вишня", "Берёза", "Бергамот", "Бирючина",
                "Боярышник", "Боярышник", "Бук", "Бук", "Венге", "Груша", "Вишня", "Драцена", "Дуб", "Дуб","Дуб", "Вирола", "Вирола"};

        // Список слов без дубликатов
        arrayToHashSet(plant);

        //Количество значений
        arrayToHashMap(plant);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addDataPerson("LastName1", "+77638746283","email1@mail.ru");
        phoneBook.addDataPerson("LastName1", "+70989089898","email2@mail.ru");
        phoneBook.addDataPerson("LastName2", "+75644656283","email3@mail.ru");
        phoneBook.addDataPerson("LastName3", "+77638748686","email4@mail.ru");

        System.out.println("email LastName1: " + phoneBook.getEmails("LastName1"));
        System.out.println("phone LastName1: " + phoneBook.getPhoneNumbers("LastName1"));
        System.out.println("email LastName2: " + phoneBook.getEmails("LastName2"));
        System.out.println("phone LastName2: " + phoneBook.getPhoneNumbers("LastName2"));
        System.out.println("email LastName3: " + phoneBook.getEmails("LastName3"));
        System.out.println("phone LastName3: " + phoneBook.getPhoneNumbers("LastName3"));
    }

    public static void arrayToHashSet(String[] args) {
        HashSet<String> plantSet = new HashSet<>();
        for (String element : args) {
            plantSet.add(element);
        }
        System.out.println(plantSet);
    }
    public static void arrayToHashMap(String[] args) {
        HashMap<Integer,String> plantMap = new HashMap<>();
        for (int i = 0; i<args.length; i++) {
            plantMap.put(i, args[i]);
        }
        Map<String, Long> values=plantMap.values().stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Количество значений: "+values);
    }
}







