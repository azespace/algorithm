package xm.space.linkedList;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/12
 * Description: 链表种某个节点 双向
 **/
public class Node<E> {
    Node prev;
    E data;
    Node next;

    Node(Node prev, E data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}