package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskExecutor {
    /*
    Заполните список (тип “ArrayList<Double>”) случайным числами и отсортируйте его.
    Вариант 5. Сортировка вставками (Insertion Sort).
    Входные данные: количество элементов в формируемом массиве n [0, ∞).
    Выходные данные: в консоль напечатаны исходный и отсортированный списки.
    */
    public static void Exec() {
        System.out.println("Задание №2. Работа со списками");
        System.out.print("Введите количество элементов в формируемом списке: ");
        Scanner scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine());
        Exec(n);
        System.out.println();
    }

    public static void Exec(int n) {
        var list = new ArrayList<Double>(n);
        System.out.println("Сформированный список:");
        System.out.print("[ ");
        for (int i = 0; i < n; ++i) {
            var randomDouble = Math.random();
            list.add(randomDouble);
            System.out.print(randomDouble + " ");
        }
        System.out.println("]");

        var sortedList = InsertionSort.GetSortedList(list);
        System.out.println("Отсортированный список:");
        System.out.print("[ ");
        for (double e: sortedList) {
            System.out.print(e + " ");
        }
        System.out.println("]");
    }
}
