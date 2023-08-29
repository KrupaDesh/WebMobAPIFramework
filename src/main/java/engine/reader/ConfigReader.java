package engine.reader;

import java.io.IOException;
import java.util.Map;

public class ConfigReader {

    public static Map<String,String> configDetails;

    static
    {
        try{
        configDetails = (new PropertiesReader().getProperties("src/test/resources/config/" + System.getProperty("config","base")+ ".properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
