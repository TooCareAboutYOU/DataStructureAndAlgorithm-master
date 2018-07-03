package com.datastructureandalgorithm.main;

/**
 * 双向链表
 */
public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
    }

    public E get(int index){
        if (index < 0 || index > size) {
            return null;
        }

        return queryNode(index).item;
    }

    private Node<E> queryNode(int index) {
        //index处于前半部分
        if (index < (size>>1)) {  //小于size 右移一位
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {  //index处于后半部分
            Node<E> node=last;
            for (int i = size-1; i > index ; i--) {
                node= node.prev;
            }
            return node;
        }
    }

    public int size(){
        return size;
    }

    //从队尾添加
    public void add(E e){
        linklast(e);
    }

    //添加到指定位置
    public void add(int index,E e){
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {  //直接添加队尾
            linklast(e);
        }else {
            Node<E> target=queryNode(index);  //根据传入的索引值 ，找到index在当前链表中相对应的元素
            Node<E> targetPrev=target.prev;   //index在当前链表中相对应的元素的上一个节点
            Node<E> newNode=new Node<>(targetPrev,e,target);  // 第一个、三步

            //注意 ：当链表size为0时， targetPrev为null
            if (targetPrev==null){
                first=newNode;
            }else {
                targetPrev.next = newNode;  //第二步
            }
            target.prev=newNode;  //第四步
            size++;
        }
    }

    //删除 指定位置
    public void remove(int index){
        if (index < 0 || index > size) {
            return;
        }
        Node<E> target=queryNode(index);

        unlinkNode(target);
    }

    public void removeAll(){
        Node<E> head=new Node<>(null,null,null);
        Node<E> end=new Node<>(null,null,head);
        head.next=end;
        size=0;
    }


    private void unlinkNode(Node<E> p){
        Node<E> targetPrev=p.prev;
        Node<E> targetNext=p.next;

        if (targetPrev == null) { // 说明 p 则为首节点
            first=p.next;
        }else {
            targetPrev.next=p.next;
        }

        if (targetNext == null) {  //  说明p 为尾节点
            last=p.prev;
        }else {
            targetNext.prev=p.prev;
        }
        size--;
    }

    private void linklast(E e) {
        Node<E> newNode=new Node<>(last,e,null);  //队尾添加
        Node<E> l=last;
        last=newNode;  // last之前已经使用
        if (l == null) {  //当链表为空的时候
            first=newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item=element;
            this.prev=prev;
            this.next=next;
        }
    }
}
