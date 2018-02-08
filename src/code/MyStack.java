import java.util.Arrays;

public class MyStack<E> {  
    private final int DEFAULT_SIZE = 100;  
    //The capacity of the stack

    private int capacity;
    //An array of data elements at the bottom

    private Object[] data;
    //The number of elements that are stored at the current stack

    private int size = 0;  
      
    //Default array expansion to left one
    private int capacityIncrementInt = 1;  

    //Initialization
    public MyStack(){  
        capacity = DEFAULT_SIZE;  
        data = new Object[capacity];  
    }  

    //Return the number of elements
    public int length(){  
        return size;  
    }  

    //Whether it is an empty stack
    public boolean isEmpty(){  
        return size == 0;  
    }  
      
    //Bit operation dilatation
    private void expendCapacity(int minCapacity){  
        while(capacity < minCapacity){  
            capacity <<= capacityIncrementInt;  
        }  
        data = Arrays.copyOf(data, capacity);  
    }  
      
    //Push
    public void push(E elem){  
        expendCapacity(size + 1);  
        data[size] = elem;  
        size ++;  
    }  
      
    //stack
    public E pop(){  
        E e = (E) data[size - 1];  
        data[size - 1] = null;  
        size --;  
        return e;  
    }  
      
    //Return to the top element of the stack, but not delete
    public E top(){  
        return (E) data[size - 1];  
    }  
      
    //Empty stack
    public void clear(){  
        if(size > 0){  
            Arrays.fill(data, null);  
            size = 0;  
        }  
    }  
}  
