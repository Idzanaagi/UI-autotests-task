package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Data properties.
 */
public final class DataProperties {

    private static final Properties PROPERTIES = new Properties();

    private static final String FILE_PATH = "src/test/resources/testData.properties";
        static {
            try (FileInputStream ip = new FileInputStream(FILE_PATH)) {
                PROPERTIES.load(ip);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    /**
     * Read property string.
     * @param key the key
     * @return the string
     */
    public static String readProperty(final String key) {
        return PROPERTIES.getProperty(key);
    }

    private DataProperties() {
        throw new IllegalStateException("Utility class");
    }
}
