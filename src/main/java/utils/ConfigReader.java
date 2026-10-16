package utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    private ConfigReader() {}

    public static void load(String fileName) {

        String path = "config/" + fileName;

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(path)) {

            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + path);
            }

            properties.clear();
            properties.load(input);

        } catch (Exception e) {

            throw new RuntimeException("Unable to load configuration: " + path, e);
        }
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Configuration key not found: " + key);
        }

        return value;
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}