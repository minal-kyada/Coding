package WinterBreak.Day13;
// https://leetcode.com/problems/lru-cache/description/

class LRUCache {
    class Node {
        int key, value;
        Node pre, post;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, Node> map;
    private int capacity, count;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.post = tail;
        tail.pre = head;
        head.pre = null;
        tail.post = null;
        map = new HashMap<Integer, Node>(capacity);
    }

    public void deleteNode(Node n) {
        n.post.pre = n.pre;
        n.pre.post = n.post;
    }

    public void addNodeToHead(Node n) {
        n.pre = head;
        n.post = head.post;
        head.post.pre = n;
        head.post = n;

    }
    
    public int get(int key) {
        if (map.get(key) != null) {
            Node n = map.get(key);
            deleteNode(n);
            addNodeToHead(n); 
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null){
            Node n = map.get(key);
            deleteNode(n); // delete node and add it back to head
            n = new Node(key, value);
            addNodeToHead(n);
            map.put(key, n);
        } else {
            Node n = new Node(key, value);
            if (count < capacity) {
                count++;
                addNodeToHead(n);
                map.put(key, n);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre); // delete node from tail
                addNodeToHead(n);
                map.put(key, n);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */