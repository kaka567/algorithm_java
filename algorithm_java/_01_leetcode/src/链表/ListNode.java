package 链表;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode{");
        sb.append("val =" + val);
        sb.append("，next =" + next);
        sb.append("}");
        return sb.toString();
    }
}
