package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环
 * */
public class _141_环形链表 {
    /**
     快慢指针
     1、慢指针指向head，一次走一步；快指针指向 head.next，一次走两步
     2、如果快慢指针相遇则有环，或者快指针先指向null则无环
     * */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
        }
        return false;
    }
}
