import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: Test
 * @author: sunwb
 * @create: 2020-04-05 10:49
 */
public class Main {
    public static void reOrderArray(int [] array) {
        Queue<Integer> q1, q2;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        for (int n : array) {
            if ((n % 2 ) == 0) q1.add(n);
            else q2.add(n);
        }
        int i = 0;
        while (!q2.isEmpty()) {
            array[i++] = q2.poll();
        }
        while (!q1.isEmpty())
            array[i++] = q1.poll();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
