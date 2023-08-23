package util;

import java.io.*;
import java.util.Date;
import java.util.Locale;

public class IOUtils {


    public static void printStat(String path){
        File rootFile = new File(path);
        if(!rootFile.exists()){
            System.out.println("Invalid file path");
            return;
        }

        if(rootFile.isDirectory()){
            System.out.println(String.format("FOLDER <%s><lastModified:%s>",
                    rootFile.getName(), new Date(rootFile.lastModified()).toString()));
            File[] files = rootFile.listFiles();
            if(files != null)
                for (File file: files) {
                    printStat(file.getPath());
                }
        } else {
            // it should be file
            System.out.println(String.format("FILE ---> <%s><Size:%d>",
                    rootFile.getName(), rootFile.length()));
        }
    }

    public static String readFile(String path){

        String data = "";
        try(Reader reader = new BufferedReader(
                new FileReader(path))) { // using try - with -resources. See AutoCloseable
            int characterCode;
            while ((characterCode = reader.read()) != -1){
                data += (char)characterCode;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void write(String data, String path){
        write(data, path, false);
    }

    public static void write(String data, String path, boolean append){
        try ( Writer writer = new BufferedWriter(new FileWriter(path, append))){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Resource res = new Resource()){
            res.addLine("Hello");
            res.addLine(" World.");
            res.printData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void copyFiles(String dstPath, String path1, String path2){
        String content1 = readFile(path1);
        String content2 = readFile(path2);
        write(content1 + content2, dstPath);
    }

    public static void copyFiles(String dstPath, String... paths){
        StringBuilder sb = new StringBuilder();
        for (String path : paths){
            sb.append(readFile(path));
        }
        write(sb.toString(), dstPath);
    }

    public static void findText(String filePath, String searchText){
        String content = readFile(filePath);
        if(content.toLowerCase().contains(searchText.toLowerCase())){
            System.out.println("Search text is found.");
        }else{
            System.out.println("Search text is not found.");
        }
    }

//    public static String readFileByLines(String path){
//        StringBuilder sb = new StringBuilder(214748364);
//        try(BufferedReader reader = new BufferedReader(
//                new FileReader(path),214748364)) {
//            int characterCode;
//            while ((characterCode = reader.read()) != -1){
//                data += (char)characterCode;
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Check you file path");
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return sb;
//    }
}

class Resource implements Closeable{
    private String data = new String();

    @Override
    public void close() throws IOException {
        if(data.length() > 0){
            data = new String();
            System.out.println("Resource data clear");
        }
    }
    public void addLine(String line){
        data += line;
    }
    public void printData(){
        System.out.println(data);
    }
}

class Tasks{
    static void t1(String path, String resultPath){
        System.out.println("TASK 1. Reverse file text.");
        //1 step: read content
       String data = IOUtils.readFile(path);

        //2. process String value (reverse)
        String result = new StringBuilder(data).reverse().toString();

        //3. write result file
        IOUtils.write(result, resultPath);
    }

//  !!!  static void t2(String filePath, String resultFilePath, String search){
//        //search word : counter
//        //example : "something" : 10 times in the text (ignoring register)
//        String data = IOUtils.readFile(filePath);
//        int counter = 0;
//        int a = 0;
//        while (a <= 15000){
//            a = data.indexOf("Мир", a);
//            counter++;
//        }
//        String result = "Number of times: " + counter;
//        System.out.println("Number of times: " + counter);
//        //IOUtils.write(result, resultFilePath);
//
//    }

    public static void main(String[] args) {
        //t1("D:\\io_tests\\tasks\\task #1.txt", "D:\\io_tests\\tasks\\result_task #1.txt");
        //!!! t2("D:\\io_tests\\war_and_peace.ru.txt",
        //        "D:\\io_tests\\t2_war_and_peace.ru.txt", "Мир");
    }
}

