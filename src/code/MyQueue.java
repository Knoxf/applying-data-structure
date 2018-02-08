public class MyQueue<E> {  
    //The subscript of the array element at the head of the team

    private int front;
    //The subscript of the array element at the end of the team

    private int rear;
    //The number of elements in a team

    private int count;
   //An array of queue elements

    private Object[] queueArray;  
   //The scale of the array

    private int size;
    //Construction method
    public MyQueue(){  
        this.size=1000;  
        this.queueArray=new Object[size];  
        front=0;  
        rear=0;   
        count=0;  
    }

    //Construction method
    public MyQueue(int size){  
        this.size=size;  
        this.queueArray=new Object[size];  
        front=0;  
        rear=0;   
        count=0;  
    }

    //Judge whether or not it is full
    public boolean isFull(){  
        return count==size;  
    }

    //Determine whether or not it is empty
    public boolean isEmpty(){  
        return count==0;  
    }

    //Insert the element of data to item at the end of the team
    public boolean Enqueue(E item){  
        if(isFull()){  
            System.out.println("full queue");  
            return false;  
        }  
        queueArray[rear]=item;  
        rear=(rear+1)%size;//Modify the team's tail pointer
        count++;  
        return true;  
    }

   //Delete the tail element of the team
    public E Dequeue(){  
        if(isEmpty()){  
            throw new RuntimeException("empty queue");  
        }  
        E item=(E)queueArray[front];  
        front=(front+1)%size;  
        count--;  
        return item;  
    }

    //Get the first element value of the team
    public E getFront(){  
        if(isEmpty()){  
            throw new RuntimeException("empty queue");  
        }  
        return (E)queueArray[front];  
    }  
    //ClearQueue
    public void clear(){  
        front=rear=count=0;  
    }    
}  