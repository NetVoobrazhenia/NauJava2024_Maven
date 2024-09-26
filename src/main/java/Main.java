public class Main {
    public static void main(String[] args) {
        System.out.println("Практическая работа №2. Вариант №5.\nВыполнил Ишоев Дмитрий\n");
        task1.TaskExecutor.Exec();
        task2.TaskExecutor.Exec();
        task3.TaskExecutor.Exec();
        task4.TaskExecutor.Exec();
        var task5 = new task5.TaskImpl();
        task5.Exec();
    }
}
