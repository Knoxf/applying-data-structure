

public class MyLinkedList<E> {
    // 结点内部类
    private class Node {
        private Object data;                  //data
        private Node next = null;          //Reference to the next node

        public Node() {                         //无参数构造函数为了创建头结点服务
            data = null;
        }

        public Node(E data) {                //带数据的构造函数
            this.data = data;
        }

    }

    private Node head;               // Head reference (pointer)
    private Node rear;                // Tail reference (pointer)
    private Node point;              //Time reference (pointer)
    private int length;                 // Chain length

    public MyLinkedList() {                  //Linked list constructors, creating a data free header node
        head = new Node();     
        rear = head;
        length = 0;
    }
    /**
     * 判断是否为空
     * 
     */
    public boolean isEmpty() {
        if(length<=0)return true;
        else return false;
    }
    /**
     * 从尾部插入链表
     * 
     */
    public void add(E elem) {
        point = new Node(elem);
        rear.next = point;
        rear = point;
        length++;

    }

    /**
     * Traversal of the output chain
     */
    public void traverse() {
        point = head;            //Mobile temporary reference to the head node
        if (head.data != null)
            System.out.print("[" + head.data + "]");
        while (point.next != null&&point.next.data != null) {
            System.out.print("-➜[" + point.next.data + "]");
            point = point.next;
        }
        System.out.println();
    }

    /**
     * Get the length of the list
     * 
     */
    public int length() {
        return length;
    }

    /**
     * Scavenging the content of the list
         * （Java garbage collection, when the object does not refer to the point, it is
     * considered garbage,the timing of the cleaning is determined by the system）
     */
    public void clear() {               
        while (head.next != null) {
            head.next = head.next.next;
        }
        rear = head;      // Back to the initial state
        point = null;
        length = 0;
        System.gc();      //Request the system to clean up the garbage
    }

    /**
     * Insert the element into a P element at a specified location
     */
    public void insert(int position, E elem) {
                if(position>=0 && position<=length){
            point = movePoint(position);
            Node tmp = new Node(elem);
            tmp.next = point.next;
            point.next = tmp;
            length++;
               }else{
                    System.out.println("No location, insert failure");
               }

    }

    /**
     * Delete the element in the specified location
     */
    public void remove(int position) {
        if (position >= 0 && position < length) {
            point = movePoint(position);
            Node tmp = point.next;
            point.next = tmp.next;
            length--;
        } else {
            System.out.println("Delete failed, no location element is specified");
        }
    }

    /**
     * Move the pointer to the specified position
         * Private methods for use by other methods
     */
    private Node movePoint(int position) {
        if (position < 0)                    //If the parameter is less than zero, move to the head
            return head;
        if (position > length)            //If the parameter is greater than the length, move to the tail
            return rear;

        if (position >= 0 && position <= length) {
            point = head;
            while (point != null) {
                if (position == 0)
                    break;
                position--;
                point = point.next;
            }
        }

        return point;

    }

    /**
     * Look up by the subscript
     */
    public E find(int position) {
        if (position >= 0 && position < length) {
            Node tmp = movePoint(position);
            return (E) tmp.next.data;
        }
        return null;
    }

    /**
     * Look up the value of the element and return the subscript
     */
    public int search(E elem) {
        point = head.next;
        int idex = -1;
        while (point != null) {
            idex++;
            if (point.data == elem)
                break;
            point = point.next;
        }
        return idex;
    }
}
