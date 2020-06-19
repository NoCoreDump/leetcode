import java.util.*;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int v) {
        this.val = v;
        this.left = null;
        this.right = null;
    }
}

public class Main{
    static TreeNode root;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        root = new TreeNode(Integer.parseInt(s[1]));

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode leftNode;
        TreeNode rightNode;
        int left, right;
        stack.push(root);
        for (int i  = 0; i < n; i++) {
            s = scanner.nextLine().split(" ");
            TreeNode node = stack.pop();
            left = Integer.parseInt(s[1]);
            right = Integer.parseInt(s[2]);
            leftNode = (left == 0) ? null : new TreeNode(left);
            rightNode = (right == 0) ? null : new TreeNode(right);
            node.left = leftNode;
            node.right = rightNode;
            if (rightNode != null) stack.push(rightNode);
            if (leftNode != null) stack.push(leftNode);

        }

        print(root);
    }
    public static void print(TreeNode root) {
        if (root == null) {
            System.out.print(" #");
            return;
        }
        System.out.print(" " + root.val);
        print(root.left);
        print(root.right);
    }
}