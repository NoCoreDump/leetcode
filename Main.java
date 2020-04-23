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
        int s = 100;
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(s);
        System.out.println(res.toString());
    }


    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int len = (sum + 1) / 2 + 1;
        int[][] dp = new int[len][len];
        Arrays.fill(dp[0], 0);

        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
            dp[i][i] = i;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len ; j++) {
                dp[i][j] = dp[i][j-1] + j;
                if (dp[i][j] == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int k = i; k <= j; k++)
                        list.add(k);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
