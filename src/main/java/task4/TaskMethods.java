package task4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class TaskMethods {
    public static String TryRequestHost() {
        try (var client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .GET()
                    .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return TryProcessResponse(response);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Не удалось запросить значение host");
        }
    }

    private static String TryProcessResponse(HttpResponse<String> response) {
        try {
            var objectMapper = new ObjectMapper();
            return objectMapper.readTree(response.body()).findValue("headers").get("Host").toString();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Не удалось обработать значение из ответа сервера");
        }
    }
}
