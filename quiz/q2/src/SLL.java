public class SLL {
    private LLNode head = null;
    private LLNode tail = null;

    public void addNode(int data) {
        LLNode newNode = new LLNode(data);

        if (head==null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display(){
        if (head == null) {
            System.out.println("SLL is empty.");
            return;
        }

        LLNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void delete(int key) {
        LLNode temp = head, prev=null;
        if (temp != null && temp.data == key) {
            head = head.next;
            return;
        }

        while (temp != null && key != temp.data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public static void main(String[] args) {
        int[] testArr = {1, 2, 3, 4, 5 , 6};
        SLL sll = new SLL();

        for (int i : testArr) sll.addNode(i);
        sll.display();
    }
}
