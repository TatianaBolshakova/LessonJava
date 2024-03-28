package Lesson4;
//Создать класс "Сотрудник" с полями: фио, должность, телефон,зарпрлата, возраст

public class Employee {
    private String name;
    private String lastName;
    private String jobTitle;
    private String numberPhone;
    private double salary;
    private int age;
    private static int id = 0;
    private int newId;

    //конструктор класса должен заполнять эти поляя при оздании объекта
    Employee(
            String name,
            String lastName,
            String jobTitle,
            String numberPhone,
            double salary,
            int age) {
        this.name = name;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.age = age;
        this.newId = ++id;

    }

    //внутри класса "Сотрудник" написать методы, которые возвращают значение каждого поля
    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    String getJobTitle() {
        return jobTitle;
    }

    String getNumberPhone() {
        return numberPhone;
    }

    double getSalary() {
        return salary;
    }

    int getAge() {
        return age;
    }

    String getInfo(Employee e) {
        return "Имя: " + e.name + ", фамилия: " + e.lastName + ", должность: " + e.jobTitle + ", id - " + e.newId;
    }
}
