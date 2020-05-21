package sort;

import generator.GeneratorArray;

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

    /*
    * @Description 插入排序
    * @param arr 无序数组
    * @Return void
    * @Author sunwb
    * @Date 2020/4/11 22:22
    **/
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--)
                swap(arr, j, j+1);
        }
    }


    /*
    * @Description 归并排序
    * @param arr
    * @Return void
    * @Author sunwb
    * @Date 2020/4/27 21:05
    **/
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sortProcess(arr, 0, arr.length - 1);
    }
    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int p = l;
        int q = mid + 1;
        int i = 0;
        while (p <= mid && q <= r) {
            tmp[i++] = (arr[p] < arr[q]) ?  arr[p++] : arr[q++];
        }
        while (p <= mid) {
            tmp[i++] = arr[p++];
        }
        while (q <= r) {
            tmp[i++] = arr[q++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = tmp[i-l];
        }
    }

    /*
     * @Description 随机快排
     * @param arr 无序数组
     * @Return void
     * @Author sunwb
     * @Date 2020/4/11 22:22
     **/
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int[] index = partition(arr, L, R);
            quickSort(arr, L, index[0]);
            quickSort(arr, index[1], R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        Random random = new Random();
        int x = arr[L + random.nextInt(R - L)];
        while (L < more) {
            if (arr[L] < x) {
                swap(arr, ++less, L++);
            } else if (arr[L] > x) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        return new int[] {less, more};
    }

    /*
    * @Description 交换数组的两个值, 位运算写法有风险（两数相等时，有一个为0），需要先判断两个值是否相等
    * @param arr
    * @param i
    * @param j
    * @Return void
    * @Author sunwb
    * @Date 2020/4/27 20:36
    **/
    public static void swap(int[] arr, int i , int j) {
        if (arr[i] == arr[j]) return;
        //交换数组的两个值，位运算写法
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args) {
//        data = GeneratorArray.generateRandomArray(100, 20);
        for (int i = 0; i < 20; i++) {
            data = GeneratorArray.generateRandomArray(100, 20);
            int[] data1 = Arrays.copyOf(data, data.length);
            quickSort(data);
            mergeSort(data1);
            for (int j = 0; j < data.length; ++j) {
                if (data[j] != data1[j]) {
                    System.out.println("*******************fuck**********************\n" + Arrays.toString(data) + "\n" + Arrays.toString(data1));
                    break;
                }
            }
        }
//        insertSort(data);
//        System.out.println("insert sort: " + Arrays.toString(data));
//        quickSort(data);
//        mergeSort(data);
//        System.out.println("quick sort: " + Arrays.toString(data));
    }
}
