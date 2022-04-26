package conversion;

        import com.sun.org.apache.bcel.internal.generic.NEW;

        import java.util.ArrayDeque;
        import java.util.Hashtable;
        import java.util.Scanner;
        import java.util.Stack;

/**
 * @author jjzmi
 * @description 实现两个大string整型的加法 返回一个string
 * @create 2021-03-14-0:25
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class TwoBigStringAdd {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static Stack<Integer> smaStack = new Stack<>();
    private static Stack<Integer> bigStack = new Stack<>();


    public static String solution(String s1,String s2){
        //进位标志
        int cb = 0;
        //较短的长度
        int length = s1.length() > s2.length() ? s2.length() : s1.length();
        if (s1.length() >= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {

                bigStack.push(Integer.parseInt(String.valueOf(s1.charAt(i))));
            }
            for (int i = 0; i < s2.length(); i++) {
                smaStack.push(Integer.parseInt(String.valueOf(s2.charAt(i))));
            }
        } else{
            for (int i = 0; i < s2.length(); i++) {
                bigStack.push(Integer.parseInt(String.valueOf(s2.charAt(i))));
            }
            for (int i = 0; i < s1.length(); i++) {
                smaStack.push(Integer.parseInt(String.valueOf(s1.charAt(i))));
            }
        }
        System.out.println("bigStack"+bigStack.toString());
        System.out.println("smaStack"+smaStack.toString());

        for (int i = 0; i < length; i++) {
            int a = smaStack.pop() + bigStack.pop() + cb;
            cb = 0;
            if (a >= 10) {
                a = a % 10;
                cb = 1;
            }
            stringBuilder.insert(0,a);
        }


        while (!bigStack.isEmpty()) {
            int a = bigStack.pop() + cb;
            cb = 0;
            if (a >= 10) {
                a = a % 10;
                cb = 1;
            }
            stringBuilder.insert(0,a);
        }

        if (cb == 1) {
            stringBuilder.insert(0,1);
        }
        return stringBuilder.toString();
    }


    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("测试开始----请输入两个大整数");
        String s1 = input.next();
        String s2 = input.next();
        System.out.println(solution(s1, s2));
    }
}
