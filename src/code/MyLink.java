import java.util.Scanner;

public class MyLink {
    public class Node{
        //Coefficient of polynomials
        private float coef;
        //Exponents of polynomials
        private int expn;
        //Point to lower node
        public Node next = null;
        public Node(float coef, int expn){
            this.coef = coef;
            this.expn = expn;
        }
    }

    /**
     * make a link class
     * Read data from the console continuously, end with (00)
     * @return  Creating the first node of the list
     */
    public Node createLink(){
        //Access the coefficients and indices that are read from the console
        float coef = 0.0f;
        int expn = 0;
        //Head and tail node (tail node is easy to insert)
        Node head, tail;
        head= new Node(-1, -1);
        head.next = null;
        tail = head;
        Scanner scanner = new Scanner(System.in);
        while(true){
            String res = scanner.nextLine();
            //Dividing a string in a row with a space
            String[] resArray = res.split("\\s+");
            coef = Float.parseFloat(resArray[0]);
            expn = Integer.parseInt(resArray[1]);
            if(coef == 0 && expn == 0.0f){
                break;
            }
            Node node = new Node(coef, expn);
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }


    /**
     * PRINT LINKLIST
     * @param head List head node
     */
    public void printLink(Node head){
        while(head != null){
            System.out.format("%.2f*X^%d + ", head.coef, head.expn);
            head = head.next;
        }
        System.out.println();
    }

    /**
     * Calculating the sum of two linked lists
     * @param nodeA
     * @param nodeB
     * @return  The final sum of the list
     */
    public Node addLink(Node nodeA, Node nodeB){
        Node nodeC = new Node(-1, -1);
        nodeC.next = null;
        //The nodes that always point to the linked list need to be processed (just beginning to remove the beginning (-1, -1) nodes)
        Node pA = nodeA.next, pB = nodeB.next, pC = nodeC;
        //The index of the two linked lists that are currently directed
        int valueAExpn = 0, valueBExpn = 0;
        while(pA != null && pB != null){
            valueAExpn = pA.expn;
            valueBExpn = pB.expn;
            if(valueAExpn < valueBExpn){
                //Add the node in A to the C, while moving the pointer to the A and C point to the next element
                pC.next = pA;
                pC = pC.next;
                pA = pA.next;
            }else if(valueAExpn > valueBExpn){
                //Add the node in B to the C, while moving the pointer to the B and C point to the next element
                pC.next = pB;
                pC = pC.next;
                pB = pB.next;
            }else{
                //The two node index is the same

                //Add the coefficients to the coefficients of the A node, and then add the A node to the C
                float sum = pA.coef + pB.coef;
                if(sum != 0.0f){
                    //The coefficient and not 0, change the coefficient of the A node to sum, and then add the A node to the C
                    pA.coef = sum;
                    pC.next = pA;
                    pC = pC.next;
                }else{
                    //Coefficient and 0, the node in the A list must be deleted from the list. If only the pointer is moved, the item will be output at the output.
                    //In order to find the entire A list, it is necessary to find the forerunner node to delete the node to remove it
                    Node s = nodeA;
                    while(s != pA){
                        s = s.next;
                    }
                    //Delete the node
                    s.next = pA.next;
                }
                //For the same coefficient, both the A and B node pointers move back.
                pA = pA.next;
                pB = pB.next;
            }
        }
        if(pA != null){
            pC.next = pA;
        }
        if(pB != null){
            pC.next = pB;
        }
        return nodeC;
    }
}
