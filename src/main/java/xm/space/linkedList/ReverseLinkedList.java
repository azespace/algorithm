package xm.space.linkedList;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/17
 * Description: 反转链表
 **/
public class ReverseLinkedList {
    /** LeetCode 206
     * 题意：反转一个单链表。
     * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     */
    static ListNode reverseLinkedList(ListNode listNode){
        ListNode pre = null ;
        ListNode cur = listNode;
        ListNode temp = null;
        while (cur!=null){
            //1.先将下一个指针保存起来
            temp = cur.next;
            //2.当前指针反转，指向前一个指针(一开始默认指向初始化的null节点)
            cur.next = pre;
            //3.当前指针处理完毕，变成下一个前驱节点
            pre = cur;
            //4.下一个当前节点由临时节点temp完成交换
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1,null);
        ListNode cur = new ListNode(0,null);
        listNode.next = cur;
        for (int i = 1; i < 5; i++) {
            cur.next = new ListNode(i,null);
            cur = cur.next;
        }
        System.out.println(listNode);
        ListNode listNode1 = reverseLinkedList(listNode);
        System.out.println(listNode1);

    }
}
