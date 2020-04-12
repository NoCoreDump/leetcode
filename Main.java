import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @program: ClassTest
 * @description: test
 * @author: sunwb
 * @create: 2020-04-10 08:56
 */
public class Main {

    /*4
            0 0
            0 50
            50 50
            50 0*/
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
////        int[][] loc = new int[n][2];
//        int [] loc = new int[n];
//        for (int i = 0; i < n; i++) {
//            String[] s = scanner.nextLine().split(" ");
//            loc[i] = Integer.parseInt(s[0]);
////            loc[i][1] = Integer.parseInt(s[1]);
//        }
        Main m = new Main();
        System.out.println((m.Permutation("aab")).toString());


    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[charArr.length];
        dfs(charArr, sb, used, res);

        return res;
    }
    public void dfs(char[] arr, StringBuilder sb, boolean[] used, ArrayList<String> res) {
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i != 0 && arr[i] == arr[i-1] && !used[i-1])
                continue;
            sb.append(arr[i]);
            used[i] = true;
            dfs(arr, sb, used,res);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;

        }

    }



}
