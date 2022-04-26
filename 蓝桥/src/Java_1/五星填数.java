package Java_1;

/**
 * @author jjzmi
 * @description
 * @create 2021-04-11-17:29
 *              0
 *        1   2   3   4
 *           5     6
 *              7
 *         8          9
 *
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 五星填数 {

    public static int count = 0;

    public  void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public  void check(int[] A) {
        int sum1 = A[0] + A[2] + A[5] + A[8];
        int sum2 = A[0] + A[3] + A[6] + A[9];
        int sum3 = A[1] + A[2] + A[3] + A[4];
        int sum4 = A[1] + A[5] + A[7] + A[9];
        int sum5 = A[4] + A[6] + A[7] + A[8];
        if(sum1 == sum2 && sum1 == sum3 && sum1 == sum4 && sum1 == sum5) {
            count++;
        } else{
            return;
        }
    }
    public  void dfs(int[] A, int step) {
        if(step == A.length) {
            check(A);
            return;
        } else {
            for(int i = step;i < A.length;i++) {
                swap(A, i, step);
                dfs(A, step + 1);
                swap(A, i, step);
            }
        }
    }


    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        五星填数 test = new 五星填数();

        int[] A =new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
        test.dfs(A, 0);
        System.out.println(count / 10);
    }

}
