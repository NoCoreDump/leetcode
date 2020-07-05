package algorithm.kmp;

import generator.GeneratorBinaryTree;
import treeUtils.Tree;
import treeUtils.TreeNode;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName KMPTest.java
 * @Description TODO
 * @createTime 2020年07月01日
 */
public class KMPTest {
    public static int getIndexOf(char[] str1, char[] str2) {
        if (str2.length > str1.length) {
            return -1;
        }
        int[] next = getNextArray(str2);
        int i1, i2;
        i1 = i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }
    public static int[] getNextArray(char[] str) {
        if (str.length == 1) return new int[] {-1};
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str[i-1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "jfiejofjeojf";
        String s2 = "ejoj";
        System.out.println(getIndexOf(s1.toCharArray(),s2.toCharArray()));
    }
}
