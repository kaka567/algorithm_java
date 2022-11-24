package 链表;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * */
public class _83_删除排序链表中的重复元素 {
    /*
    给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
    输入：1 -> 1 -> 2 -> 3 -> 3
    输出：1 -> 2 -> 3
    * */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        System.out.println(node);
        System.out.println(deleteDuplicates2(node));
    }

    // 递归
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    // 双指针
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nodeX = head;
        ListNode nodeY = head.next;
        while (nodeY != null) {
            if (nodeX.val == nodeY.val) {
                nodeX.next = nodeY.next;
                nodeY.next = null;
            } else {
                nodeX = nodeX.next;
            }
            nodeY = nodeX.next;
        }
        return head;
    }
}
