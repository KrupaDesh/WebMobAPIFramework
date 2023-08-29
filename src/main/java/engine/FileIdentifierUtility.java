package engine;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileIdentifierUtility {
        private static final ArrayList<Path> listOfFilePaths = new ArrayList<>();

        /*To find the file with specific extension*/

        public static ArrayList<Path> readFileList(DirectoryStream<Path> stream, String fileExtension) throws IOException {
            for(Path path : stream){
                if(!Files.isDirectory(path))
                    if(path.getFileName().toString().endsWith(fileExtension)){
                        System.out.println("Path:"+path);
                        listOfFilePaths.add(path);
                    }
                else
                    readFileList(Files.newDirectoryStream(path), fileExtension);

            }
            return listOfFilePaths;
        }
}
