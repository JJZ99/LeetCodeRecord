package conversion;


import java.util.Scanner;

/**
 * @author jjzmi
 * @description  16进制---》8进制
 * @create 2021-03-04-23:45
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class HexToOct {

    public static String convert(String str) {
        int strLength = str.length();
        int a = strLength / 6;
        int b = strLength % 6;
        String ans = "";
        for (int i = 0; i < a; i++) {
            String item = Integer.toOctalString(
                    Integer.valueOf(
                            str.substring(strLength - (i + 1) * 6, strLength - i * 6), 16));
            ans = item + ans;
        }
        if (b != 0) {
            String item = Integer.toOctalString(
                    Integer.valueOf(str.substring(0, b), 16));
            ans = item + ans;
        }
        return ans;

    }
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strArray = new String[num];

        for (int i = 0; i <num ; i++) {
            strArray[i] = scanner.next();
        }
        for (int i = 0; i < num; i++) {
            String ans = convert(strArray[i]);
            System.out.println(ans);
        }
    }
}