package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * */
public class _237_删除链表中的节点 {

    /**
     思路：
     1、将当前节点的下一个节点的值赋给当前节点
     2、将当前节点的next指向下个节点的下个节点
     * */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
