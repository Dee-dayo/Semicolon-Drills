package chapter15;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        String location = "C:\\DELL\\Desktop\\";
        String location2 = "C:\\Users\\DELL\\Desktop\\ibile plug.jpg";
        Path path = Path.of(location);
        Path path2 = Paths.get(location2);


        //To create a file
        String file = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\sample.txt"; //d sample.txt is d name of d file and extension u want
        Path path3 = Paths.get(file);
        try {
            Files.createFile(path3);
        } catch (IOException e) {
//            e.printStackTrace();
        }

        //directory stream
        Path path4 = Paths.get("C:\\Users\\DELL\\Documents\\");  //dis points to a folder cus it cycles through a directory for the contents

        try(DirectoryStream<Path> paths = Files.newDirectoryStream(path4)){
            paths.forEach(System.out::println);

//            paths.forEach(p->{if(Files.isDirectory(p)) System.out.println(p);});

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
