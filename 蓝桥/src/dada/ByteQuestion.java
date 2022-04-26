package dada;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-30-15:27
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ByteQuestion {

    /**
     * 获取有二进制表示的byte中1的数量
     * @param N byte number
     * @return count
     */
    public static int byteBinaryOneNumber(byte N) {
        int count = 0;
        while (N != 0) {
            count++;
            byte rightOne = (byte) (N & (-N));
            N ^= rightOne;
        }
        return count;
    }

    public static byte reverseByte(byte N) {
        return 2;
    }



    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

//        byte s = 127;
//        System.out.println(byteBinaryOneNumber(s));
        byte s = 6;
        System.out.println(Integer.toBinaryString(s));
        System.out.println(Integer.reverseBytes(s));
        int a = Integer.reverse(s);
        System.out.println(a);
        System.out.println(Integer.toBinaryString(1610612736));
    }
}
