package sort;

import generator.GeneratorArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: sort algorithm
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j-1])
                    swap(arr, j, j-1);
            }
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
        int mid = l + (r - l) / 2;
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[arr.length];
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            tmp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = tmp[i];
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
        if (L >= R) return;
        int[] index = partition(arr, L, R);
        int less = index[0];
        int more = index[1];
        quickSort(arr, L, less);
        quickSort(arr, more, R);
    }

    private static int[] partition(int[] arr, int L, int R) {
        int x = new Random().nextInt(R - L + 1);
        x = arr[L + x];
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < x) {
                swap(arr, ++less, L++);
            } else if (arr[L] > x) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        int[] index = new int[2];
        index[0] = less;
        index[1] = more;
        return index;
    }
    /*
     * @Author sunwb
     * @Description 堆排，默认从小到大
     * @Date 21:35 2020/6/1
     * @Param [arr]
     * @return void
     **/
    public static void heapSort(int[] arr) {
        //建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        //将堆顶元素与数组最后一个元素交换，使用指针直至所有元素交换完毕
        int size = arr.length;
        //最小元素放置在数组末尾
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //堆顶元素下沉
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        int parent = (index - 1) / 2;
        while (index != 0 && arr[index] > arr[parent]) {
            swap(arr, index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    /*
    * @Description 交换数组的两个值, 位运算写法
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
            heapSort(data1);
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
