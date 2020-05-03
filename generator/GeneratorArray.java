package generator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 产生随机数组
 * @author: sunwb
 * @create: 2020-04-29 08:11
 */
public class GeneratorArray {
    public static int[] generateRandomArray(int bound, int len) {
        Random random = new Random();
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = random.nextInt(bound);
        }
        System.out.println("generate array: " + Arrays.toString(data));
        return data;
    }

}
