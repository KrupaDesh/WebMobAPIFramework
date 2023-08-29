package engine.reader;

import engine.FileIdentifierUtility;
import engine.constants.Config;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import static engine.constants.Paths.TEST_DATA_ROOT_PATH;
import static engine.reader.ConfigReader.configDetails;

public class TestDataReader {

    public static HashMap<String, Object> allTestData =new HashMap<String, Object>();

    static{
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(TEST_DATA_ROOT_PATH +configDetails.get(Config.TEST_DATA)));
            ArrayList<Path> paths = FileIdentifierUtility.readFileList(stream, ".json");
            for(Path path: paths){
                allTestData.putAll(MyJsonReader.readJsonObject(path));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
