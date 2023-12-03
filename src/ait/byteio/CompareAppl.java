package ait.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareAppl {
    public static void main(String[] args) {
        // TODO Homework
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        System.out.println("file1 = " + args[0]);
        System.out.println("file2 = " + args[1]);
        try (FileInputStream fi1 = new FileInputStream(new File(args[0]));
             FileInputStream fi2 = new FileInputStream(args[1])) {
            int byte1 = 0;
            int byte2 = 0;
            do {
                byte1 = fi1.read();
                byte2 = fi2.read();
                if (byte1 != byte2) {
                    break;
                }
            } while (byte1 != -1 && byte2 != -1);

            if (byte1 == byte2) {
                System.out.println("The same files");
            } else {
                System.out.println("The different files");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}