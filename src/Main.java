import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static String PATH = "/home/mrdzen/folda";
    public static void main(String[] args) {

        System.out.println("Total files in directory:"+fileCounter(PATH));

        fileCounter1(PATH);
    }

    private static int fileCounter(String pathFolder) {
        File directory = new File(pathFolder);
        int fileCount = directory.list().length;
        return fileCount;
    }

    private static void fileCounter1(String pathFolder) {
        List<String> fileNames = new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathFolder));
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File Count:"+fileNames.size());
    }


}