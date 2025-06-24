package ua.orlov.fintechtransaction.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SqlLoader {

    public static String load(String fileName) {
        try {
            Path path = new ClassPathResource("sql/" + fileName).getFile().toPath();
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load SQL file: " + fileName, e);
        }
    }
}
