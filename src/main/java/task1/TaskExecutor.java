package task1;

import java.util.Random;
import java.util.Scanner;

public class TaskExecutor {
    /*
    Заполните массив (тип элементов “int”) случайными числами.
    Вариант 5. Найти сумму положительных элементов массива.
    Входные данные: количество элементов в формируемом массиве n [0, ∞).
    Выходные данные: в консоль напечатаны массив и результат поиска в соответствии с заданием.
    */
    public static void Exec() {
        System.out.println("Задание №1. Работа с массивом");
        System.out.print("Введите количество элементов в формируемом массиве: ");
        Scanner scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine());
        Exec(n);
        System.out.println();
    }

    public static void Exec(int n) {
        var arr = new int[n];
        var random = new Random();
        long sum = 0;
        System.out.println("Сформированный массив:");
        System.out.print("[ ");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt();
            System.out.print(arr[i] + " ");
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        System.out.println("]");
        System.out.println("Сумма положительных элементов массива: " + sum);
    }
}
