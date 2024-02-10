package Lesson4;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee(
                "Татьяна",
                "Большакова",
                "стажер-тестировщик",
                "+7-923-481-21-39",
                30000.0,
                33
        );
        System.out.println(employee.getInfo(employee));

        //массив из 5 сотрудников
        Employee[] employees = {
                employee,
                new Employee("Сотрудник 2", "Фамилия 2", "инженер -тестировщик", "+7-923-481-21-33", 50000.0, 25),
                new Employee("Сотрудник 3", "Фамилия 3", "инженер -программист", "+7-923-481-21-44", 70000.0, 37),
                new Employee("Сотрудник 4", "Фамилия 4", "инженер -программист", "+7-923-481-21-55", 80000.0, 48),
                new Employee("Сотрудник 5", "Фамилия 5", "инженер -программист", "+7-923-481-21-66", 90000.0, 55)
        };

        //информация о сотрудниках старше 40
        infoEmployeeOpAge(employees, 40);

        //Повысить з/п на 10000 сотрудникам старше 35 лет
        verhogenSalary(employees, 35, 10000);

    }

    public static void infoEmployeeOpAge(Employee[] e, int age) {
        System.out.println("Старше " + age + " лет: ");
        for (Employee employee : e) {
            if (employee.getAge() > 40) {
                System.out.println(employee.getInfo(employee));
            }
        }
    }

    public static void verhogenSalary(Employee[] e, int age, int verhogenNumber) {
        System.out.println("Повысить з/п на " + verhogenNumber + " сотрудникам старше " + age + "  лет: ");
        for (Employee employee : e) {
            if (employee.getAge() > age) {
                double newSalary = employee.getSalary() + 10000;
                System.out.println(employee.getName() + "новая з/п = " + newSalary);
            }
        }
    }
}
