import java.util.HashMap;

//LRU缓存实现
public class Solution146 {
    private HashMap<Integer,Node> map;
    private DoubleList cache;  //双向链表
    public int cap;//容量

    public Solution146(int capacity) {
        this.cap = capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }

    private void makeRecently(int key){ //将某个key的值提升到最近使用
        Node node =map.get(key);  //获取key的值
        cache.remove(node); //删除key
        cache.addLast(node);  //放到链表的最后 表示最近使用
    }

    private void addRecently(int key,int val){//如果元素没有被使用过,就添加
        Node node=new Node(key,val);
        cache.addLast(node);
        map.put(key,node);  //添加数据到map
    }
    private void deleteKey(int key){
        Node node=map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    private void removeLeastRecently(){
        Node delNode=cache.removeFirst();
        int delKey=delNode.key;
        map.remove(delKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key,value);
            return;
        }
        if (cap==cache.size()) {
            removeLeastRecently();
            addRecently(key, value);
        }
    }
}

class Node {
    public int key, val;
    public Node next, pre;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class DoubleList{
    private Node head,tail;
    private int size;
    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addLast(Node node){
        node.pre=tail.pre;
        node.next=tail;
        tail.pre.next=node;
        tail.pre=node;
        size++;
    }
    public void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
        size--;
    }

    public Node removeFirst(){
        if (head.next==tail)
        {
            return null;
        }
        Node first=head.next;
        remove(first);
        return first;
    }
    public int size(){
        return size;
    }
}
