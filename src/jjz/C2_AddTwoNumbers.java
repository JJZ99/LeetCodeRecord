package jjz;

/**
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-26-20:39
 * @description: https://leetcode-cn.com/problems/add-two-numbers/submissions/
 */
public class C2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode nextLeft = l1.next;
        ListNode nextRight = l2.next;
        if (!(null == l1 && null == l1)) {
            head.val = (l1.val + l2.val) % 10;
        }
        int next1v = 0;
        int next2v = 0;
        ListNode curr = head;
        int temp = (l1.val + l2.val) / 10;

        while (null != nextLeft || null != nextRight) {
            if (nextLeft==null){
                next1v = 0;
            }else {
                next1v = nextLeft.val;
                nextLeft = nextLeft.next;

            }
            if (nextRight == null) {
                next2v = 0;

            } else {
                next2v = nextRight.val;
                nextRight = nextRight.next;

            }
            curr.next = new ListNode((next1v + next2v + temp)% 10);
            if (next1v + next2v + temp >= 10) {
                temp = 1;
            } else {
                temp = 0;
            }
            curr = curr.next;
        }
        if (temp == 1) {
            curr.next = new ListNode(1);
        }
        return head;


    }

    public static void main(String[] args) {
        ListNode one1 = new ListNode(9);
        ListNode one2 = new ListNode(9);
        ListNode one3 = new ListNode(9);
        ListNode one4 = new ListNode(9);
        ListNode one5 = new ListNode(9);
        ListNode one6 = new ListNode(9);
        ListNode one7 = new ListNode(9);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
        one5.next = one6;
        one6.next = one7;

        ListNode two1 = new ListNode(9);
        ListNode two2 = new ListNode(9);
        ListNode two3 = new ListNode(9);
        ListNode two4 = new ListNode(9);
        two1.next = two2;
        two2.next = two3;
        two3.next = two4;
        ListNode listNode = addTwoNumbers(one1, two1);
        System.out.println(listNode);

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
