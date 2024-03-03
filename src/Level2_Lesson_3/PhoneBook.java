package Level2_Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<Person>> dataPerson = new HashMap<>();

    public void addDataPerson(String lastName, String phoneNumber, String email) {
        if (dataPerson.containsKey(lastName)) {
            ArrayList<Person> persons = dataPerson.get(lastName);
            persons.add(new Person(lastName, phoneNumber, email));
//            System.out.println(lastName);
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(lastName, phoneNumber, email));
            dataPerson.put(lastName, persons);
//            System.out.println(lastName);
        }
    }

    public ArrayList<String> getPhoneNumbers(String lastName) {
        if (dataPerson.containsKey(lastName)) {
            ArrayList<Person> persons = dataPerson.get(lastName);
            ArrayList<String> phoneList = new ArrayList<>();
            for (Person person : persons) {
                phoneList.add(person.phoneNumber);
            }
            return phoneList;
        } else {
            return null;
        }
    }

    public ArrayList<String> getEmails(String lastName) {
        if (dataPerson.containsKey(lastName)) {
            ArrayList<Person> persons = dataPerson.get(lastName);
            ArrayList<String> emailList = new ArrayList<>();
            for (Person person : persons) {
                emailList.add(person.email);
            }
            return emailList;
        } else {
            return null;
        }
    }

}
