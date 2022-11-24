package 链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * */
public class _876_链表的中间节点 {

    /**
     数组
     对链表进行遍历，依次放入数组中
     * */
    public ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int index = 0;
        while (head != null) {
            arr[index++] = head;
            head = head.next;
        }
        return arr[index / 2];
    }

    /**
     单指针
     第一次遍历获取元素个数，第二次遍历到中间为止，这样比数组那种方式节省空间
     * */

    /**
     快慢指针
     慢指针一次走一步，快指针一次走两步，这样当快指针走到尾的时候，慢指针就处于中间的位置
     * */
}
