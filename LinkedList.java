public class LinkedList {
    public Node head = null;

    public void addNodeAtTheBeginning(int data) {
        System.out.println("Add a node with data " + data + " in the beginning.");
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void addNodeAtTheEnd(int data) {
        System.out.println("Add a node with data " + data + " at the end.");
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void add(int position, int data) {
        System.out.println("Add a node with data " + data + " at the position " + position);
        Node newNode = new Node(data);
        Node cur = this.head, prev = this.head;

        if (position == 1) {
            newNode.next = head;
            this.head = newNode;
            return;
        }
        while (cur.next != null && --position > 0) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = newNode;
        newNode.next = cur;
    }

    public void deleteNodeAtTheBeginning() {
        System.out.println("Delete a node at the beginning");
        int data = head.data;
        Node newNode = new Node(data);
        if (this.head.data == data) {
            this.head = this.head.next;
            return;
        }
    }

    public void deleteNodeAtTheEnd() {
        System.out.println("Delete a node at the end");
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return;
    }
    public void deleteNodeByIndex(int index) {
        System.out.println("Delete a node with index " + index);

        Node cur = this.head;

        if (cur == null) {
            this.head = this.head.next;
            return ;
        } else if (index == 0) {
            return ;
        } else {
            Node n = cur;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
            return ;
        }
    }

    public void changeNodeAtTheBeginning(int data) {
        System.out.println("Change a node by data " + data + " in the beginning.");
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head.next;
            this.head = newNode;
        }
    }
    public void changeNodeAtTheEnd(int data) {
        System.out.println("Change a node by data " + data + " at the end.");
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node cur = this.head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            return;
        }
    }

    public void changeNodeByIndex(int index, int data) {
        System.out.println("Change a node with index " + index + " by data " + data);

        Node cur = this.head;
        Node newNode = new Node(data);

        if (cur == null) {
            System.out.println("The List is empty."); ;
        } else if (index == 0) {
            this.head = newNode;
        } else {
            Node n = cur;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = newNode;
            return ;
        }
    }

    public int getSum() {
        System.out.println("Get sum of list");
        int sum = 0;
        Node cur = this.head;
        while (cur.next != null) {
          sum = cur.data + sum;
          cur = cur.next;
        }
        sum+= cur.data;
        return sum;
    }
    public int searchIndexByElement(int data) {
        System.out.println("Index of Element " + data);
        Node newNode = new Node(data);
        Node cur = this.head, prev = this.head;
        int count = 0;
        while (cur != null && cur.data != data) {
            count++;
            prev = cur;
            cur = cur.next;
        }
        return count;
    }


    public void print() {
        if (this.head == null) {
            System.out.println("The List is empty.");
        } else {
            System.out.println("The contents of the Singly Linked List are : ");
            Node cur = this.head;
            while (cur != null) {
                System.out.print(cur.data + " -> ");
                cur = cur.next;
            }
            System.out.println("NULL\n");
        }
    }
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Created a singly linked list .....");
        list.print();

        long tStart1 = System.nanoTime();
        list.addNodeAtTheBeginning(100);
        long tEnd1 = System.nanoTime();
        System.out.println("Time of inserting node at the beginning :"+(tEnd1-tStart1)+"ns");
        list.print();

        list.addNodeAtTheBeginning(200);
        list.print();

        long tStart2 = System.nanoTime();
        list.addNodeAtTheEnd(900);
        long tEnd2 = System.nanoTime();
        System.out.println("Time of inserting node at the end "+(tEnd2-tStart2)+"ns");
        list.print();

        list.addNodeAtTheEnd(800);
        list.print();

        long tStart4 = System.nanoTime();
        list.add(1,150);
        long tEnd4 = System.nanoTime();
        System.out.println("Time of inserting node by index "+(tEnd4-tStart4)+"ns");
        list.print();

        list.add(4,250);
        list.print();

        list.add(6,250);
        list.print();

        long tStart5 = System.nanoTime();
        list.deleteNodeAtTheBeginning();
        long tEnd5 = System.nanoTime();
        System.out.println("Time of deleting first node : "+(tEnd5-tStart5)+"ns");
        list.print();

        long tStart6 = System.nanoTime();
        list.deleteNodeAtTheEnd();
        long tEnd6 = System.nanoTime();
        System.out.println("Time of deleting last node : "+(tEnd6-tStart6)+"ns");
        list.print();

        long tStart = System.nanoTime();
        list.deleteNodeByIndex(1);
        long tEnd7 = System.nanoTime();
        System.out.println("Time of deleting node by index :  "+(tEnd7-tStart)+"ns");
        list.print();

        long tStart8 = System.nanoTime();
        list.changeNodeAtTheBeginning(10);
        long tEnd8 = System.nanoTime();
        System.out.println("Time of changing first node : "+(tEnd8-tStart8)+"ns");
        list.print();

        long tStart9 = System.nanoTime();
        list.changeNodeAtTheEnd(10);
        long tEnd9 = System.nanoTime();
        System.out.println("Time of changing last node : "+(tEnd9-tStart9)+"ns");
        list.print();

        long tStart10 = System.nanoTime();
        list.changeNodeByIndex(0,100);
        long tEnd10 = System.nanoTime();
        System.out.println("Time of changing node by index : "+(tEnd10-tStart10)+"ns");
        list.print();

        long tStart11 = System.nanoTime();
        System.out.println(list.getSum());
        long tEnd11 = System.nanoTime();
        System.out.println("Time of getting sum of list : "+(tEnd11-tStart11)+"ns");
        System.out.print("\n");

        long tStart12 = System.nanoTime();
        System.out.println(list.searchIndexByElement(100));
        long tEnd12 = System.nanoTime();
        System.out.println("Time of searching index by element : "+(tEnd12-tStart12)+"ns");
    }
}