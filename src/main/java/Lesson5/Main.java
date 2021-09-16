package Lesson5;

import java.io.IOException;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {

        try
        {
            System.out.println(
                    FileMethod.countSeq(Paths.get("src/main/resources/file/lesson5/1/File1.txt"), "Hello")
            );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileMethod.joinFilesText(Paths.get("src/main/resources/file/lesson5/1"),
                    Paths.get("src/main/resources/file/lesson5/1/new1.txt"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileMethod.rmRf(Paths.get("src/main/resources/file/lesson5/2"));
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
