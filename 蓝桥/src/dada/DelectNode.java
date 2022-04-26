package dada;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.HashMap;
import java.util.List;

/**
 * @author jjzmi
 * @description 删除链表的倒数第n个节点
 *                要求时间复杂度O（n）！！！！！
 * @create 2021-03-20-14:40
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class DelectNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode quick = head;
        for(int i = 1;i < n; i++ ){
            quick = quick.next;
        }
        while (quick.next != null) {
            pre = slow;
            slow = slow.next;
            quick = quick.next;
        }

        //判断要删除的是不是第一个节点
        if(slow == head){
            return head.next;
        }
        HashMap<String, String> sd = new HashMap<>();

        pre.next = slow.next;
        return head;
        // write code here
    }
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode real = head;
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        ListNode ans = removeNthFromEnd(head, 1);
    }

}
