package streamapithree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3,10,43,213,54,23,5,11));

        List<Integer> resultStream = list.stream()
                .filter(a -> a > 10)
                .sorted(Task3::sortedInteger)
                .collect(Collectors.toList());

        System.out.println(resultStream);
    }

    public static int sortedInteger(Integer number1, Integer number2){
        int lastNum1 = number1 % 10;
        int lastNum2 = number2 % 10;

        if(lastNum1 > lastNum2){
            return 1;
        }
        if(lastNum1 < lastNum2){
            return -1;
        }
        return 0;
    }
}
