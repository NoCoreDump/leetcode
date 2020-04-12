package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 各种排序算法
 * @author: sunwb
 * @create: 2020-04-11 22:20
 */
public class Sort {

    private static int[] data;
    public static void makeRandomArray(int bound, int len) {
        Random random = new Random();
        data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = random.nextInt(bound);
        }
        System.out.println(Arrays.toString(data));
    }
    /*
    * @Description 插入排序
    * @param arr 输入的无需数组
    * @Return void
    * @Author sunwb
    * @Date 2020/4/11 22:22
    **/
    public static void insertSort(int[] arr) {

    }

    public static void main(String[] args) {
        makeRandomArray(100, 20);
    }
}
