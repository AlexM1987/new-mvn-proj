package io;
import lombok.Data;
import util.IOUtils;
import java.io.*;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        File file = new File("D:/io_tests/new_file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("New file is created - " + isCreated);


            File file2 = new File("D:/io_tests/simple_file2.txt");
            boolean isExists = file2.exists();
            if (!isExists) {
                file2.createNewFile();
                System.out.println("New file is created");
            }


            File file3 = new File("D:\\io_tests");
            System.out.println("path:" + file3.getPath());
            System.out.println("name:" + file3.getName());
            File files[] = file3.listFiles();
            System.out.println("pathnames size : " + files.length);

            System.out.println("***************");
            //IOUtils.printStat("C:\\Windows");

            InputStream is = new FileInputStream(new File("D:/io_tests/war_and_peace.ru.txt"));
            int code = is.read();
            System.out.println("Code = " + code);
            char ch = (char) code;
            System.out.print(ch);

            Date startDate0 = new Date();
            while ((code = is.read()) != -1){
                System.out.print(((char)code) );
            }
            Date endDate0 = new Date();
            System.out.println("---------------------------");



            Reader reader = new FileReader("D:/io_tests/simple_file.txt");
            int characterCode;
            while ((characterCode = reader.read()) != -1){
                System.out.print((char)characterCode);
            }


            System.out.println("----------123-----------------");
            Date startDate = new Date();
            Reader reader2 = new BufferedReader(
                    new FileReader("D:/io_tests/war_and_peace.ru.txt"));
            int characterCode2;
            while ((characterCode2 = reader2.read()) != -1){
                System.out.print((char)characterCode2);
            }
            Date endDate = new Date();
            long mills = endDate.getTime() -startDate.getTime();
            System.out.println("processing took " + mills);
            System.out.println("processing0 took " + (endDate0.getTime() -startDate0.getTime()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}