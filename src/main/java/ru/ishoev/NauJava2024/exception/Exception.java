package ru.ishoev.NauJava2024.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Exception {
    private String message;

    public static Exception create(Throwable e) {
        return new Exception(e.getMessage());
    }

    public static Exception create(String message) {
        return new Exception(message);
    }
}