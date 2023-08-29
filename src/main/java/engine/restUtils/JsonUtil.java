package engine.restUtils;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

import static engine.constants.Paths.*;

public class JsonUtil  {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getJsonDataAsMap(String jsonFileName, Class<T> classname) throws IOException {
        String compleJsonFilePath = TEST_DATA_API_ROOT_PATH+ jsonFileName;
        return objectMapper.readValue(new File(compleJsonFilePath), classname);

    }
 /*   public static Map<String,String> getJsonDataAsMap(String jsonFilePath, Class<T> classname) throws IOException {
        String compleJsonFilePath = System.getProperty("user.dir")+ "src/tet/resources/testData/api"+jsonFilePath;
        Map<String,String >data = objectMapper.readValue(new File(compleJsonFilePath), new TypeReference<>(){});
        return data;
    }*/

/*    public static Response readAllAPIDetailsFromJson(String ) {
        // Read JSON file
        String jsonFilePath = "path/to/your/json/file.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));



        // Parse JSON content
        JSONObject jsonData = new JSONObject(jsonContent);



        // Extract URL, headers, and request body from JSON
        String url = jsonData.getJSONObject("loginAPIUrl").getString("url");
        JSONObject headers = jsonData.getJSONObject("headers");
        JSONObject requestPayload = jsonData.getJSONObject("loginApiPayload");



        // Make Rest Assured request
        RequestSpecification request = RestAssured.given();
        request.headers(headers.toMap());
        request.body(requestPayload.toString());



        // Send the request and get the response
        Response response = request.post(url);



        // Print the response
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }*/
}
