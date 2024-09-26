package task5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskImpl implements ITask {
    /*
    Необходимо реализовать интерфейс Task.
    Вариант 5. Реализуйте интерфейс “Task” для сканирования сети на открытые порты в заданном диапазоне.
    При нахождении открытого порта, информация о нем печатается в консоль.
    Методы start() начинает сканирование, а stop() прерывает его.
    Для выполнения задания рекомендуется использовать класс “java.net.Socket”.
    */
    final static String ip = "127.0.0.1";
    final static int timeout = 100;
    private ExecutorService es;

    public void Exec() {
        System.out.println("Задание №5. Реализация интерфейса Task");
        start();
        stop();
    }

    @Override
    public void start() {
        es = Executors.newFixedThreadPool(8);
        for (int port = 1; port <= 65535; ++port) {
            es.submit(TryCheckPort(port));
        }
        es.shutdown();
    }

    private static Runnable TryCheckPort(int port) {
        return () -> {
            try (var socket = new Socket()) {
                socket.connect(new InetSocketAddress(ip, port), timeout);
                System.out.println("Порт " + port + " открыт");
            } catch (IOException ignored) {
            }
        };
    }

    @Override
    public void stop() {
        es.shutdownNow();
    }
}
