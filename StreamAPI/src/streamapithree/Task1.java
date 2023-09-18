package streamapithree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Task1 {
    public static void main(String[] args) {
        String str = "Hello World hgfhgf ooeororoeoro word";

        String[] resultStr= str.split("[ ,.!?]");
        List<String> stream = Arrays.stream(resultStr)
                .filter(Task1::predicateFilter)
                .sorted(Task1::comparatorSorted)
                .collect(Collectors.toList());

        System.out.println(stream);
    }

    public static int comparatorSorted(String str1, String str2){

        List<Character> characters = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        int countFirst = countSimvols(str1, characters);
        int countSecond = countSimvols(str2, characters);


        if(countFirst > countSecond){
            return 1;
        }
        if(countFirst < countSecond){
            return -1;
        }

        return 0;

    }

    public static boolean predicateFilter(String str){
        List<Character> characters = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        if(countSimvols(str, characters) == 0){
            return false;
        }

        return true;
    }

    public static int countSimvols(String str, List<Character> characters){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(characters.contains(str.charAt(i))){
                count++;
            }
        }
        return count;
    }


}
