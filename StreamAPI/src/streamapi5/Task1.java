package streamapi5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("D:\\test.txt");

        String[] resultStringFiles = readFile(file).split("[ ]");

        List<File> listFile = new ArrayList<>();

        listFiles(resultStringFiles, listFile);

        Optional<File> stream = listFile.stream()
                .filter(a -> predicateFile(a) >= 3)
                .findFirst();

        System.out.println(stream.get().getName());
    }

    public static String readFile(File file){
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while(br.ready()){
                result += br.readLine() + " ";
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static void listFiles(String[] nameFolder, List<File> list){
        for(var str : nameFolder){
            list.add(new File(str));
        }
    }

    public static int predicateFile(File file){
        int count = 0;
        File[] files = file.listFiles();

        for(var nameFil : files){
            if(nameFil.isFile()){
                String[] resultFormat = nameFil.getName().split("[.]");
                if(resultFormat[1].equals("txt")){
                    count++;
                }
            }
        }
        return count;
    }
}
