package generator;

import treeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 根据数组生成二叉树
 * @author: sunwb
 * @create: 2020-05-02 10:50
 */
public class GeneratorBinaryTree {
    public static TreeNode generateBinaryTree(int[] data) {
        if (data == null || data.length <= 0) return null;
        Arrays.sort(data);
        return getNextNode(data, 0, data.length - 1);
    }

    private static TreeNode getNextNode(int[] data, int l, int r) {
        if (l < 0 || r >= data.length || l > r) return null;
        if (l == r) return new TreeNode(data[l]);
        int mid = l + ((r - l) >> 1);
        TreeNode node = new TreeNode(data[mid]);
        node.left = getNextNode(data, l, mid - 1);
        node.right = getNextNode(data, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] data = GeneratorArray.generateRandomArray(100, 20);

    }
}
