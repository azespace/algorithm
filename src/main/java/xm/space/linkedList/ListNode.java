package xm.space.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/12
 * Description: 链表种某个节点 单向
 **/
@Data
@AllArgsConstructor
public class ListNode {
    /**
     * 存放的数据
     *
     */
    int val;
    /**
     * 下一个链表
     */
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
