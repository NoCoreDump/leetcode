

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
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int res = 0;
        ArrayList<ArrayList<Integer>> inData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] s = scanner.nextLine().split(" ");
            for (int j = 0; j <= i; j++) {
                list.add(Integer.parseInt(s[j]));
            }
            inData.add(list);
        }
        for (ArrayList<Integer> l : inData)
            System.out.println(l.toString());
//        res = maxMoney(inData);
        System.out.println(res);
    }
    public static int maxMoney(ArrayList<ArrayList<Integer>> list) {
        for (int i = list.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = Math.max(list.get(i+1).get(j), list.get(i+1).get(j+1));
                list.get(i).set(j, list.get(i).get(j) + Math.max(list.get(i+1).get(j), list.get(i+1).get(j+1)));
            }
        }
        return list.get(0).get(0);
    }

}
