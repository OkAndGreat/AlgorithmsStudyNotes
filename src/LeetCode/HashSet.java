package LeetCode;

import java.util.Stack;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */


public class HashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));// 返回 True
        System.out.println(myHashSet.contains(3));// 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));// 返回 False ，（已移除
    }
}

class MyHashSet {

    /**
     * Initialize your data structure here.
     */
    Node[] headNode;

    public MyHashSet() {
        headNode = new Node[10];
        for (int i = 0; i < 10; i++) {
            //Careful The Array of headNode is Null,needs to be initalized!
            headNode[i] = new Node();
            headNode[i].value = i;
            Stack<Integer> integers = new Stack<>();
        }
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        Node toAddNode = new Node();
        toAddNode.value = key;
        int index = HashFun(key);
        Node temp = headNode[index];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = toAddNode;
    }

    public void remove(int key) {
        int index = HashFun(key);
        Node temp = headNode[index];
        while (temp.next!=null) {
            if (temp.next.value == key) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
            if(temp==null){
                break;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        boolean exist = false;
        int index = HashFun(key);
        Node temp = headNode[index];
        while (temp.next != null) {
            if (temp.next.value == key) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        return exist;
    }

    private int HashFun(int value) {
        return value % 10;
    }
}

class Node {
    public Node next;
    public int value;
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
