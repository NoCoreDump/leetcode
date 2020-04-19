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

    public static void main(String[] args) {
        int[] nums = {30, 32, 321};
        System.out.println(fun(nums));
    }
    public static String fun(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            arr[i] = new Integer(nums[i]);
        }
        baseSort(arr);
        for (int n : arr) {
            sb.append(n);
        }
        return sb.toString();
    }
    public static void baseSort(Integer[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String .valueOf(o2);
                for (int i = 0; i < Math.max(s1.length(), s2.length()); ++i) {
                    char c1, c2;
                    if (i >= s1.length()) c1 = s1.charAt(0);
                    else c1 = s1.charAt(i);
                    if (i >= s2.length()) c2 = s2.charAt(0);
                    else c2 = s2.charAt(i);
                    if (c1 != c2) return c1 - c2;

                }
                return 0;
            }
        });
    }

}
