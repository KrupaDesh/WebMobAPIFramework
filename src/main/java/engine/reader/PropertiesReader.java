package engine.reader;

import com.google.common.collect.Maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

        public Map<String, String> getProperties(String propertyFileName) throws IOException {
            FileReader reader = new FileReader(propertyFileName);
            Properties prop = new Properties();
            prop.load(reader);
            return Maps.newHashMap(Maps.fromProperties(prop));
        }
}
