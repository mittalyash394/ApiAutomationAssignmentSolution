package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;
    private final String propertyFilePath = "Configuration.properties";

    public PropertyReader() {
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

    public String getValueFromConfig(String varName){
        String value = properties.getProperty(varName);
        if(value!=null){
            return value;
        }
        else {
            throw new RuntimeException(varName+" is not specified in configuration");
        }
    }
}






