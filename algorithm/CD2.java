package algorithm;

/*题目描述
        先给出可整合数组的定义：如果一个数组在排序之后，每相邻两个数的差的绝对值都为1，或者该数组长度为1，则该数组为可整合数组。
        例如，[5, 3, 4, 6, 2]排序后为[2, 3, 4, 5, 6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组
        给定一个数组arr, 请返回其中最大可整合子数组的长度。例如，[5, 5, 3, 2, 6, 4, 3]的最大可整合子数组为[5, 3, 2, 6, 4]，所以请返回5
        [要求]
        时间复杂度为O(n^2)，空间复杂度为O(n)
        输入描述:
        第一行一个整数N，表示数组长度
        第二行N个整数，分别表示数组内的元素

        输出描述:
        输出一个整数，表示最大可整合子数组的长度

        示例1
        输入
        7 5 5 3 2 6 4 3
        输出
        5
        */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName CD2.java
 * @Description TODO
 * @createTime 2020年06月22日
 */
public class CD2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        int res = getLen(arr);
        System.out.println(res);
    }
    public static int getLen(int[] arr) {
        int res = 0;
        if (arr == null || arr.length == 0) {
            return res;
        }
        int max, min;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            set.clear();
            for (int j = i; j < arr.length; j++) {
                if (!set.add(arr[j])) {

                    break;
                }
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    res = Math.max(res, j-i+1);
                }
            }

        }
        return res;
    }
}
