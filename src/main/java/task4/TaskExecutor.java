package task4;

public class TaskExecutor {
    /*
    Необходимо сделать “GET” запрос на указанный адрес и обработать ответ.
    Вариант 5. Вывести только значение хоста сервера (поле “Host”) из заголовков
    (запрос выполняется по адресу “https://httpbin.org/get”).
    Выходные данные: в консоль напечатан результат выполнения запроса
    обработанный в соответствии с вариантом задания.
    */
    public static void Exec() {
        System.out.println("Задание №4. HTTP клиент и JSON");
        System.out.println(TaskMethods.TryRequestHost());
        System.out.println();
    }
}
