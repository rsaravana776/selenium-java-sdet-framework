package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static final ObjectMapper objectMapper =
            new ObjectMapper();

    private JsonUtils() {
    }

    public static List<Map<String, String>> readJsonFile(
            String filePath) {

        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Map<String, String>>>() {
                    }
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read JSON file: " + filePath,
                    e
            );
        }
    }
}