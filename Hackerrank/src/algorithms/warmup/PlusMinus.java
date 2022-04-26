package algorithms.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @Author: zhaojunjie
 * @E-mail: jjz.miss.3344@outlook.com
 * @Date: 2022-04-24-11:13
 * @Description: https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
 */
class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        Integer sum = new Integer(arr.size());
        Float zheng = new Float(0);
        Float zone = new Float(0);
        Float fu = new Float(0);
        Iterator<Integer> iterator = arr.iterator();
        while (iterator.hasNext()) {
            int temp_ = iterator.next();
            if (temp_ > 0) {
                zheng++;
            } else if (temp_ == 0) {
                zone++;
            } else {
                fu++;
            }
        }
        System.out.printf("%.6f\n",zheng / sum);
        System.out.printf("%.6f\n",fu / sum);
        System.out.printf("%.6f\n",zone / sum);
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
