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

    public static void main(String[] args)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] path = new int[10][10];
        String[] inStr = new String[n];
        for (int i = 0; i < n; i++) {
            inStr[i] = scanner.nextLine();
        }
//        System.out.println(Arrays.toString(inStr));

        for (String s : inStr) {
            String[] ss = s.split(" ");
            int start = Integer.parseInt(ss[1]);
            int end = Integer.parseInt(ss[2]);
            if ("1".equals(ss[0])) {
                int w = Integer.parseInt(ss[3]);
                update(path, start, end, w);
            } else {
                res.add(getCost(path, start, end));
            }
        }
        for (int r : res)
            System.out.println(r);
    }

    private static int getCost(int[][] path, int start, int end) {
        int cost = 0;
        int p1, p2;
        p1 = start;
        p2 = end;
        while (p1 != p2) {
            if (p1 < p2) {
                int p = p2;
                p2 = (p2 % 2 == 0) ? p2 / 2 : (p2 - 1) / 2;
                cost += path[p][p2];

            } else {
                int p = p1;
                p1 = (p1 % 2 == 0) ? p1 / 2 : (p1 - 1) / 2;
                cost += path[p][p1];
            }
//            System.out.println("Cost: " + cost);
        }
        return cost;
    }

    private static void update(int[][] path, int start, int end, int w) {
        int p1, p2;
        p1 = start;
        p2 = end;
        while (p1 != p2) {
            if (p1 < p2) {
                int p = p2;
                p2 = (p2 % 2 == 0) ? p2 / 2 : (p2 - 1) / 2;
                path[p2][p] += w;
                path[p][p2] += w;
            } else {
                int p = p1;
                p1 = (p1 % 2 == 0) ? p1 / 2 : (p1 - 1) / 2;
                path[p1][p] += w;
                path[p][p1] += w;
            }
        }
//        System.out.println("parent : " + p1);
    }

}
