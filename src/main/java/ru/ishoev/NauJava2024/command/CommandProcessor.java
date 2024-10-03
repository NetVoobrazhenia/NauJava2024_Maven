package ru.ishoev.NauJava2024.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ishoev.NauJava2024.service.RegionService;

@Component
public class CommandProcessor {
    private final RegionService regionService;

    @Autowired
    public CommandProcessor(RegionService regionService) {
        this.regionService = regionService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0]) {
            case "create" -> {
                var id = regionService.createRegion(cmd[1], Short.valueOf(cmd[2]));
                System.out.println("Регион успешно добавлен. Уникальное id региона:" + id);
            }
            case "get" -> {
                var region = regionService.findById(Long.valueOf(cmd[1]));
                System.out.println("Регион c id " + cmd[1] + ": " + region);
            }
            case "update" -> {
                if (regionService.updatePhoneCode(Long.valueOf(cmd[1]), Short.valueOf(cmd[2])))
                    System.out.println("Телефонный код региона успешно обновлен...");
                else
                    System.out.println("Не удалось обновить телефонный код...");
            }
            case "delete" -> {
                regionService.deleteById(Long.valueOf(cmd[1]));
                System.out.println("Регион успешно удален...");
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
