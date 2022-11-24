package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * */
public class _206_反转链表 {

    /**
     递归
     1、如果原链表是：5 - 4 - 3 - 2 - 1 - null，传入的头结点是5
     2、那么调用了 reverseList1(head.next) 返回的是 1 - 2 - 3 - 4 - null
     3、所以只需要将 4 的 next 指向 5，5 的 next 指向 null
     * */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     迭代
     1、在遍历链表时，将当前节点的 next\textit{next}next 指针改为指向前一个节点
     2、由于节点没有引用其前一个节点，因此必须事先存储其前一个节点
     3、在更改引用之前，还需要存储后一个节点。最后返回新的头引用
     * */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
