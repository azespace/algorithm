package xm.space.linkedList;

import java.util.Iterator;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/12
 * Description: 设计双向链表
 **/
public class LinkedListImpl2<E> implements Iterable<E>{
    private Node first;  //链表的首元素
    private Node last;   //链表的尾元素
    private int total;

    public void add(E e){
        // 添加一个元素在尾部 尾部元素变成当前元素的prev 添加元素的last为null
        Node newNode = new Node(last, e, null);
        // 如果first为null 说明数组为空， 那么 last也即是null 所以这个节点成为了唯一的节点
        if(first == null){
            first = newNode;
        }else{
            // 反之就是有数据， 那么就放在链表末尾
            last.next = newNode;
        }
        // 更新链表的尾元素
        last = newNode;
        total++;
    }

    public int size(){
        return total;
    }

    public void delete(Object obj){
        // 找到元素节点
        Node find = findNode(obj);
        if(find != null){
            if(find.prev != null){
                // 将当前节点的前一个元素next指向当前节点的next
                find.prev.next = find.next;
            }else{
                // 当前节点是头部元素 则将当前节点的下一个元素设为头部元素
                first = find.next;
            }
            if(find.next != null){
                // 将当前节点的下一个元素的prev指向当前节点的prev;
                find.next.prev = find.prev;
            }else{
                // 当前节点是尾部元素 则将当前节点的前一个元素设为尾部元素
                last = find.prev;
            }
            //  回收
            find.prev = null;
            find.next = null;
            find.data = null;
            total--;
        }
    }

    private Node findNode(Object obj){
        Node node = first;
        Node find = null;
        // 直接循环查找
        if(obj == null){
            while(node != null){
                if(node.data == null){
                    find = node;
                    break;
                }
                node = node.next;
            }
        }else{
            while(node != null){
                if(obj.equals(node.data)){
                    find = node;
                    break;
                }
                node = node.next;
            }
        }
        return find;
    }

    public boolean contains(Object obj){
        return findNode(obj) != null;
    }

    public void update(E old, E value){
        Node find = findNode(old);
        if(find != null){
            find.data = value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E>{
        // 迭代器实现元素遍历 主要是就是hasNext是否存在  next取出数据
        private Node<E> node = first;

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public E next() {
            E value = node.data;
            node = node.next;
            return value;
        }
    }
}
