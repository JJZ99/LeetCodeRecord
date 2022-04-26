package lesson01;

import java.util.*;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-02-11:09
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ReverseLinked {
    public static class Node{
        int value;
        Node nextNode;

        public Node() { }
        public Node(int value) { this.value = value; }
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
    }
    public static  class  DoubleNode{
        int value;
        DoubleNode nextNode;
        DoubleNode lastNode;

        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
        public DoubleNode() { }
        public DoubleNode(int value) { this.value = value; }
    }

    /**
     * 反转单链表
     * @param head
     * @return head
     */
    public static Node reverseSingleLink(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.nextNode;
            head.nextNode = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试反转单链表的方法
     * @param head
     * @return
     */
    public  static  Node testReverseSingleLink(Node head){
        if (head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.nextNode;
        }

        list.get(0).nextNode = null;
        for (int i = list.size()-1; i >0 ; i--) {
            list.get(i).nextNode = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleLink( DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head!=null) {
            next = head.nextNode;
            head.nextNode = pre;
            head.lastNode = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试反转双向链表的方法
     * @param head
     * @return
     */
    public static DoubleNode testReverseDoubleLink(DoubleNode head) {
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.nextNode;
        }

        list.get(0).nextNode = null;

        for (int i = 0; i <list.size() ; i++) {
            if (i == 0) {
                list.get(i).nextNode = null;
                list.get(i).lastNode = list.get(i + 1);
            }

            list.get(i).nextNode = list.get(i - 1);
            list.get(i).lastNode = list.get(i + 1);
            if (i == (list.size() - 1)) {
                list.get(i).nextNode = list.get(i - 1);
                list.get(i).lastNode = null;
            }
        }
        return list.get(list.size() - 1);
    }
    public  static  Node randomLinkNode(int maxLength,int maxValue){
        int size = (int) (Math.random() * (maxLength + 1));
        if (size == 0) {
            return null;
        }
        Node head = new Node((int) (Math.random() * (maxValue + 1)-Math.random() * (maxValue + 1)));
        Node cur = head;
        size--;
        for (int i = 1; i <size ; i++) {

            Node node = new Node((int) (Math.random() * (maxValue + 1)-Math.random() * (maxValue + 1)));
            cur.nextNode = node;
            cur = node;
        }
        return head;
    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.nextNode;
        }
        return ans;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.nextNode;
        }
        return true;
    }

    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.nextNode;
        }
        return ans;
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.nextNode;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.lastNode;
        }
        return true;
    }

    public static void Print(Node head){
        if (head != null) {
            while (head != null) {
                System.out.print(head.value + ",");
                head = head.nextNode;
            }
            System.out.println();
        } else {
            System.out.println("空链表");
        }
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        //最大长度
        int maxlength = 50;
        //次数
        int testTimes = 500000;
        //[-50,50]
        int maxValue = 50;

        for (int i = 0; i <testTimes ; i++) {
            Node head = randomLinkNode(maxlength, maxValue);
            Print(head);
            List<Integer> list = getLinkedListOriginOrder(head);
            Node ans = reverseSingleLink(head);
            Print(ans);
            //list.toArray();

            if (!checkLinkedListReverse(list,ans)) {
                System.out.println("第"+i+"次错了 fuck fucking！！！");
                return;
            }
        }
        System.out.println("nice！！！！！");


    }







}
