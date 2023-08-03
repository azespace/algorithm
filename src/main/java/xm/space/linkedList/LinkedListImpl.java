package xm.space.linkedList;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/12
 * Description: 设计链表
 **/
public class LinkedListImpl {
    /** LeetCode 707
     * 在链表类中实现这些功能：
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    //增加节点数量字段很关键,没有这个数量很难查询指定索引的值。因为你不清楚索引是否越界。
    int size;
    ListNode listNode;
    public LinkedListImpl() {
        size = 0;
        //不算是虚拟节点算是初始化的节点 获取和删除的时候计算在内
        listNode=new ListNode(0);
    }
    public int get(int index) {
        //1.index是索引 所以需要保证索引大于0以及不能大于等于size
        if (index < 0 || index >= size){
            return -1;
        }
        //2.依次遍历就可以了，找到当前索引直接返回值。
        ListNode cur = listNode;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    public void addAtIndex(int index, int val) {
        //1.在某个索引节点处插入就相当于在该索引节点和他的前驱节点中间放入一个新的节点。所以用前驱节点判断插入位置比较合适
        //2.大于size什么都不做(size没记录虚拟节点的),小于size在头部节点插入
        if (index > size){
            return ;
        }
        if (index < 0){
            index = 0;
        }
        //3.如果等于size就放在最末尾节点相当于在size位置前面插入
        size++;
        ListNode pre = listNode;
        //4.遍历找到该节点的前驱节点 所以for循环的时候使用i < index处理。
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode addNode = new ListNode(val);
        //5.前驱节点的下一个变成插入节点的下一个  该节点变成前驱节点的下一个 完成插入
        addNode.next = pre.next;
        pre.next = addNode;
    }
    public void deleteAtIndex(int index) {
        //1.非索引不处理
        if (index<0||index>=size){
            return;
        }
        size--;
        //2.如果是0 移动指针处理
        if (index==0){
            listNode = listNode.next;
            return;
        }
        //3.还是用前驱节点处理
        ListNode pre = listNode;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //4.前驱节点的下一个变成 下下个 完成删除。
        pre.next = pre.next.next;
    }
}
