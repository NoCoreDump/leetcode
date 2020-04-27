import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @program: ClassTest
 * @description: test
 * @author: sunwb
 * @create: 2020-04-10 08:56
 */
public class Main {
    int[] arr;
    public static void main(String[] args)
    {
        int[] array = new int[]{1,2,3,4,5,6,7,0};
        Main main = new Main();
        main.arr = new int[array.length];
        System.out.println(main.InversePairs(array));
    }
    public int InversePairs(int [] array) {
        if (array.length == 0) return 0;
        int[] res = new int[1];
        mergeSort(res, array, 0, array.length - 1);
        return res[0];
    }
    public void mergeSort(int[] res, int[] array, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(res, array, l, mid);
        mergeSort(res, array, mid+1, r);
        merge(res, array, l, mid, r);
    }
    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
    public void merge(int[] res, int[] array, int l, int mid, int r) {
        int L = mid;
        int R = r;
        int i = r;
        while (L >= l && R > mid) {
            if (array[L] <= array[R]) {
                arr[i] = array[R];
                R--;
            } else {
                res[0] += R - mid;
                arr[i] = array[L];
                L--;
            }
            i--;
        }
        if (L == l - 1) {
            while (R > mid) {
                arr[i--] = array[R--];
            }
        }
        if (R == mid) {
            while (L >= l) {
                arr[i--] = array[L--];
            }
        }
        i = l;
        while (i <= r) {
            array[i] = arr[i];
            i++;
        }
    }

}
