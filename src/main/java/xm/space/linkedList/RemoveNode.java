package xm.space.linkedList;

import java.util.List;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/12
 * Description: 移除链表某个节点
 **/
public class RemoveNode {
    /** LeetCode 203
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
     * 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     * 列表中的节点数目在范围 [0, 104] 内
     * 1 <= Node.val <= 50
     * 0 <= val <= 50
     */
    static ListNode removeEle(ListNode listNode,int val){
        if (listNode == null){
            return listNode;
        }
        //1.移除某个节点的第一个节点不好处理,使用虚拟头节点解决掉
        ListNode virtualNode = new ListNode(-1,listNode);
        //2.前面的节点
        ListNode pre = virtualNode;
        //3.当前节点
        ListNode cur = pre.next;
        //4.节点尾部终止循环
        while(cur!=null) {
            //5.是需要移除的数据，头节点的下一个节点指向当前节点的下一个节点，移除当前节点。
            //  不是需要移除的，当前节点变成pre。当前节点向下移动一个节点。表示向下遍历。
            if (cur.val==val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return  virtualNode.next;
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
        ListNode listNode1 = removeEle(listNode, 4);
        System.out.println(listNode1);
    }
}
