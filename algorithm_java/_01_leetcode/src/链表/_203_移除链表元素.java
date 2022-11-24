package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出：1->2->3->4->5
 * */
public class _203_移除链表元素 {

    /**
     递归
     * */
    public  ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     虚拟头结点(因为头结点有可能被删除)
     1、先创建一个虚拟头节点，让该节点的next指向head
     2、然后创建一个指针指向该虚拟头结点，通过next指针逐步往后遍历
     * */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tempNode = dummyHead;
        while (tempNode.next != null) {
            if (tempNode.next.val == val) {
                tempNode.next = tempNode.next.next;
            } {
                tempNode = tempNode.next;
            }
        }
        return  dummyHead.next;
    }
}
