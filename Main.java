import java.util.ArrayList;
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
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 && popA.length == 0) return true;

        ArrayList<Integer> stack = new ArrayList<>();
        //HashSet<Integer> set = new HashSet<>();
        int i = 0;
        for (int n : popA) {
            while (i < pushA.length && pushA[i++] != n) {
                stack.add(pushA[i-1]);
            }
            if (n == stack.get(stack.size()-1)) {
                stack.remove(stack.size()-1);
            }
        }
        return stack.size()==0 ? true : false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(IsPopOrder(arr,pop));
    }
}
