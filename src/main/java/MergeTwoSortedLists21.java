/**
 * @author ZHUANG Yiwei on 2021/9/7
 */
public class MergeTwoSortedLists21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode temp = ret;
        ListNode cur;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp.next = cur;
            temp = temp.next;
        }
        while (l1 != null) {
            cur = new ListNode(l1.val);
            l1 = l1.next;
            temp.next = cur;
            temp = temp.next;
        }
        while (l2 != null) {
            cur = new ListNode(l2.val);
            l2 = l2.next;
            temp.next = cur;
            temp = temp.next;
        }
        return ret.next;
    }

    public static void printListNode(ListNode l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }


    public static void main(String[] args) {
        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode b0 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);

        a0.next = a1;
        a1.next = a2;
        b0.next = b1;
        b1.next = b2;

//        printListNode(a0);
//        printListNode(b0);
        printListNode(mergeTwoLists(a0, b0));

    }
}
