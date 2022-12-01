package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Read the attributes from the Configuration.properties file
 *
 * Created by Prashanth Raju
 *
 */

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/properties/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    //Read the attribute value from the Configuration.properties file
    public String getAttrValue(String attr) {
        String attrValue = properties.getProperty(attr);
        if (attr != null) return attrValue;
        else throw new RuntimeException(attr + " not specified in the Configuration.properties file.");
    }
}