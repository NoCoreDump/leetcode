import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr == null || arr.length == 0)
            System.out.println(-1);
        Arrays.sort(arr);
        int count = getMinBills(arr, n-1, aim);
        System.out.println(count);
    }
    public static int getMinBills(int[] arr, int i, int aim) {
        if (i < 0) return aim == 0 ? 0 : -1;

        int count = 0;
        int rest = aim % arr[i];
        int y = aim / arr[i];
        if (rest == 0) {
            count += y;
            return count;
        } else {
            int next = getMinBills(arr, i-1, rest);
            if (next == -1) return -1;
            else return y + next;
        }

    }
}