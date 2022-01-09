package FileHandling;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {

        int c = 0;
        try {
            File myObj = new File("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\a_an_example.in.txt");
            Scanner myReader = new Scanner(myObj);

            c = myReader.nextInt();

            System.out.println(c);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\a_answer.txt");
            myWriter.write(String.valueOf(c));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
