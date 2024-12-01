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

    final static String PATH_SOURCE = "/home/mrdzen/folda/";
    final static String PATH_OUTPUT = "/home/mrdzen/temp/";
    public static void main(String[] args) {

        System.out.println("Total files in directory:"+fileCounter(PATH_SOURCE));

        fileCounter1(PATH_SOURCE);
        fileRenamer();
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

    private static void fileRenamer()
    {
        String prefix="";
        File folder = new File(PATH_SOURCE);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                File f = new File(PATH_SOURCE +listOfFiles[i].getName());
                if( (i>=0) && (i<10))
                {prefix="0"+i;}
                else {prefix = String.valueOf(i);}
                f.renameTo(new File(PATH_OUTPUT +prefix+".png"));
            }
        }
    }





}