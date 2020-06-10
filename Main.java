

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @program: ClassTest
 * @description: test
 * @author: sunwb
 * @create: 2020-04-10 08:56
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int v) {
        this.val = v;
        this.next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        ListNode head = addNode(nums);
        head = deleteDuplication(head);
        printListNode(head);
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode addNode(int[] nums) {
        ListNode pHead;
        ListNode head = new ListNode(nums[0]);
        pHead = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            head.next = node;
            head = head.next;
        }
        return pHead;
    }
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;
        //头结点重复
        boolean flag = false;
        if (pHead.val == pHead.next.val) {
            flag = true;
        }
        while (pHead.next!= null && flag) {
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
            if (pHead == null || pHead.next == null) return pHead;
            if (pHead.val == pHead.next.val) {
                flag = true;
            } else {
                break;
            }
        }
        ListNode pre, h;
        pre = pHead;
        h = pre.next;
        while (h != null && h.next != null) {
            if (h.val == h.next.val) {
                while (h.next != null && h.val == h.next.val) {
                    h = h.next;
                }
                pre.next = h.next;
                h = h.next;
            } else {
                pre = h;
                h = h.next;
            }
        }
        return pHead;
    }

}
