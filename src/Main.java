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
//        fileRenamer();   // is working
        fileRenamer1();
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

    private static void fileRenamer1()
    {
        String folder_path =PATH_SOURCE;
        String prefix="";

        // creating new folder
        File myfolder = new File(folder_path);

        File[] file_array = myfolder.listFiles();
        for (int i = 0; i < file_array.length; i++)
        {

            if (file_array[i].isFile())
            {

                File myfile = new File(folder_path + file_array[i].getName());
                String long_file_name = file_array[i].getName();
                if( (i>=0) && (i<10))
                {prefix="0"+i;}
                else {prefix = String.valueOf(i);}

                String new_file_name =prefix
                        ;// tokens[1];
                System.out.println(long_file_name);
                System.out.print(new_file_name);

                // file name format: "Snapshot 11 (12-05-2017 11-57).png"
                // To Shorten it to "11.png", get the substring which
                // starts after the first space character in the long
                // _file_name.
                myfile.renameTo(new File(PATH_OUTPUT + new_file_name + ".png"));
            }
        }
    }




}