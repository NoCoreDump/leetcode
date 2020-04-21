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
        System.out.println(GetUglyNumber_Solution(7));
    }
    public static int GetUglyNumber_Solution(int index) {
        int i = 1;
        if (index == 1) return 1;
        while (index > 0) {
            if (isUglyNumber(i++))
                index--;
        }
        return i - 1;
    }

    public static boolean isUglyNumber(int n) {
        boolean flag = false;
        while (n > 1) {
            if (n % 5 == 0) {
                n /= 5;
                flag = true;
            }
            if (n % 3 == 0) {
                n /= 3;
                flag = true;
            }
            if (n % 2 == 0) {
                n /= 2;
                flag = true;
            }

            if (n != 1 && !flag) return flag;
            flag = false;
        }
        return true;
    }

}
