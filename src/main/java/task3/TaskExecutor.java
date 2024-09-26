package task3;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskExecutor {
    /*
    Необходимо обработать список с использованием Stream API.
    Вариант 5. Определить, есть ли хотя бы один сотрудник с зарплатой более 100000.00.
    Выходные данные: в консоль напечатан результат выполнения задания.
    Объекты должны быть напечатаны в читаемом виде.
    */
    private static final ArrayList<Employee> PrefilledList = new ArrayList<>(Arrays.asList(
            new Employee("Кортев Станислав", 19, "Отдел контроля", 80000.),
            new Employee("Григорьев Андрей", 20, "Отдел разработки", 110000.),
            new Employee("Столяров Михаил", 21, "Отдел разработки", 70000.),
            new Employee("Никитин Кирилл", 22, "Отдел поддержки", 40000.),
            new Employee("Гуламов Павел", 23, "Отдел исследований", 90000.),
            new Employee("Савицких Владимир", 24, "Отдел исследований", 100000.),
            new Employee("Прилепин Максим", 25, "Отдел поддержки", 50000.)
    ));

    public static void Exec() {
        System.out.println("Задание №3. Stream API");
        System.out.printf(
                "В компании%s существует сотрудник с зарплатой более 100000.00\n",
                PrefilledList.stream().anyMatch(employee -> employee.getSalary() > 100000.) ? "" : " не"
        );
        System.out.println();
    }
}
