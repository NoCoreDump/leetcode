package treeUtils;

import generator.*;
/**
 * @program: leetcode
 * @description:
 * @author: sunwb
 * @create: 2020-05-02 12:09
 */
public class Tree {

    static String deserializeStr = null;
    /*
    * @Description 按照先序遍历的顺序序列化
    * @param root
    * @Return java.lang.String
    * @Author sunwb
    * @Date 2020/5/2 12:17
    **/
    public static String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    /*
    * @Description 反序列化
    * @param str
    * @Return treeUtils.TreeNode
    * @Author sunwb
    * @Date 2020/5/3 10:33
    **/
    public static TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        deserializeStr = str;
        return deserialize();
    }
    private static TreeNode deserialize() {
        int index = deserializeStr.indexOf(",");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }

    public static void main(String[] args) {
        int[] data = GeneratorArray.generateRandomArray(10,7);
        TreeNode root = GeneratorBinaryTree.generateBinaryTree(data);
        System.out.println(GeneratorBinaryTree.verticalOrder(root).toString());
        String ss = Serialize(root);
        System.out.println(ss);
        TreeNode head = Deserialize(ss);
        System.out.println(GeneratorBinaryTree.verticalOrder(head).toString());
    }
}
