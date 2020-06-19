package treeUtils;

import generator.*;

import java.util.*;

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

    /**
     * @title
     * @description 先序遍历递归打印
     * @author sunwb
     * @updateTime 20-6-19 下午2:34
     * @throws
     */
    public static void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
    /**
     * @title
     * @description 先序遍历非递归实现
     * @author sunwb
     * @updateTime 20-6-19 下午2:41
     * @throws
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    /**
     * @title
     * @description 后序遍历打印
     * @author sunwb
     * @updateTime 20-6-19 下午3:26
     * @throws
     */
    public static void posOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderPrint(root.left);
        posOrderPrint(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * @title
     * @description 后序遍历非递归实现
     * @author sunwb
     * @updateTime 20-6-19 下午3:26
     * @throws
     */
    public static List<Integer> posOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * @title
     * @description 层次遍历
     * @author sunwb
     * @updateTime 20-6-19 下午2:30
     * @throws
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new LinkedList<>();
            while (count -- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * @title
     * @description 中序遍历非递归实现
     * @author sunwb
     * @updateTime 20-6-19 下午2:29
     * @throws
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                head = cur.right;
            }
        }
        return ans;
    }
    /**
     * @title
     * @description 中序遍历打印递归实现
     * @author sunwb
     * @updateTime 20-6-19 下午2:29
     * @throws
     */
    public static void inOrderPrint(TreeNode root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.print(" " + root.val);
        inOrderPrint(root.right);
    }
    public static void main(String[] args) {
        int[] data = GeneratorArray.generateRandomArray(10,7);
        TreeNode root = GeneratorBinaryTree.generateBinaryTree(data);
        posOrderPrint(root);
        System.out.println();
        System.out.println(posOrder(root));
    }
}
