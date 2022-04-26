package test;

import java.util.*;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-15-22:30
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Test {

    public static int getMatchBracketsNum (String inString, int inStringNum) {

        int counter = 0;
        if (inString == "") {
            return 0;
        }
        if (inStringNum % 2 != 0) {
            return -1;
        }
        Deque<String> stack = new ArrayDeque();

        for (int i = 0; i < inStringNum; i++) {
            String r = inString.substring(i, i + 1);
            if (!stack.isEmpty()){
                String s = stack.peek();
                if ("{".equals(s) && "}".equals(r)) {
                    counter += 3;
                    stack.pop();

                } else if ("[".equals(s) && "]".equals(r)) {
                    counter += 2;
                    stack.pop();


                }else if ("(".equals(s) && ")".equals(r)) {
                    counter += 1;
                    stack.pop();
                } else {
                    stack.push(r);
                }

            }else{
                stack.push(r);
            }
        }
        // write code here
        return counter;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int index = s.indexOf(",");
        String s1 = s.substring(1, index - 1);
        String s2 = s.substring(index+1);
        int n = Integer.parseInt(s2);
        System.out.println(getMatchBracketsNum(s1, n));
    }

}
