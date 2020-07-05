package treeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName TrieTree.java
 * @Description TODO
 * @createTime 2020年06月24日
 */
class TrieNode {
    int path; //经过该节点的字符串个数
    int end;  //以该点结束的字符串个数
    Map<Character, TrieNode> nextMap;
    public TrieNode () {
        path = 0;
        end = 0;
        nextMap = new HashMap<>();
    }
}
public class TrieTree {

    public TrieNode root;
    public TrieTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return ;
        char[] words = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            if (!node.nextMap.isEmpty() && node.nextMap.containsKey(words[i])) {
                node = node.nextMap.get(words[i]);

            } else {
                TrieNode nextNode = new TrieNode();
                node.nextMap.put(words[i], nextNode);
                node = nextNode;
            }
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (word == null || word.length() == 0) return;
        if (search(word) != 0) {
            char[] words = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < words.length; i++) {
                TrieNode next = node.nextMap.get(words[i]);
                next.path--;
                if (next.path == 0) {
                    node.nextMap.remove(words[i]);
                    return;
                }
                node = next;
            }
            node.end--;
        }
    }

    public int search(String word) {
        if (word == null) return 0;
        char[]  words = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            if (node.nextMap.isEmpty() || !node.nextMap.containsKey(words[i])) {
                return 0;
            } else {
                node = node.nextMap.get(words[i]);
            }
        }
        return node.end;
    }

    public void print() {
        if (root.nextMap.size() == 0) return;
        preOrder(root);
    }
    private void preOrder(TrieNode root) {
        if (root == null) return;
        Map<Character, TrieNode> map = root.nextMap;
        for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
            preOrder(entry.getValue());
        }


    }
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abcde");
        trieTree.insert("abcxyz");
        trieTree.insert("xyz");
        trieTree.print();
        trieTree.delete("abcde");
        trieTree.print();
    }
}
