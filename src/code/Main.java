import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	
	static void judgeBalance(String str){
		MyStack<String> myStack=new MyStack<String>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(c=='}')
			{
				if(!myStack.isEmpty()&&myStack.top().charAt(0)=='{')myStack.pop();
				else {
					System.out.println("Not");
					return;
				}
			}
			else if(c==']')
			{
				if(!myStack.isEmpty()&&myStack.top().charAt(0)=='[')myStack.pop();
				else {
					System.out.println("Not");
					return;
				}
			}
			else if(c==')')
			{
				if(!myStack.isEmpty()&&myStack.top().charAt(0)=='(')myStack.pop();
				else {
					System.out.println("Not");
					return;
				}
			}
			else myStack.push(String.valueOf(c));
		}
		if(myStack.isEmpty())System.out.println("Balanced");
		else System.out.println("Not");
	}
	
	static void Josephus(int n,int m)
	{
		MyQueue<Integer> myQueue=new MyQueue<Integer>();
		for(int i=1;i<=m;i++)
		{
			myQueue.Enqueue(i);
		}
		int temp=1;
		while(!myQueue.isEmpty())
		{
			int buf=myQueue.getFront();
			myQueue.Dequeue();
			if(temp%n==0)
			{
				System.out.print(buf+" ");
			}
			else myQueue.Enqueue(buf);
			++temp;
		}
		System.out.println();
	}
	public static void main(String[] args){	
		//1
		MyLink myLink = new MyLink();
        System.out.println("Please input the coefficient and the index of the first polynomial in turn");
        MyLink.Node nodea = myLink.createLink();
        System.out.println("Please input the coefficients and indices of the second polynomials in turn");
        MyLink.Node nodeb = myLink.createLink();
        System.out.println("The first polynomial of the input is: ");
        myLink.printLink(nodea.next);
        System.out.println("The second polynomials that are input are: ");
        myLink.printLink(nodeb.next);
        MyLink.Node nodec = myLink.addLink(nodea, nodeb);
        System.out.println("Sum of two polynomials: ");
        myLink.printLink(nodec.next);
		
		
		
		//2
		try { // Prevent file establishment or read failure, capture errors and print with catch, or throw

            /* read txt. file */
            String pathname = "D:\\java project\\datastructures\\input1.txt"; // The absolute path or the relative path is OK, here is the absolute path, and the relative path is demonstrated when the file is written.
            File filename = new File(pathname); // To read the input of the above path. Txt file
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // Setting up an input stream object reader
            BufferedReader br = new BufferedReader(reader); // Create an object that turns the content of a file into a language that the computer can read
            String line = "";  
            line = br.readLine(); 
            while (line != null) { 
            	judgeBalance(line);
                line = br.readLine(); // Read a row of data at a time
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		//3
		try { //Prevent file establishment or read failure, capture errors and print with catch, or throw

            /* read txt. file */
            String pathname = "D:\\java project\\datastructures\\input3.txt"; // The absolute path or the relative path is OK, here is the absolute path, and the relative path is demonstrated when the file is written.
            File filename = new File(pathname); // To read the input of the above path. Txt file
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // Setting up an input stream object reader
            BufferedReader br = new BufferedReader(reader); // Create an object that turns the content of a file into a language that the computer can read
            String line = "";  
            line = br.readLine(); 
            while (line != null) { 
            	String[] temp=line.split(" ");
            	int n=Integer.parseInt(temp[0]);
            	int m=Integer.parseInt(temp[1]);
            	Josephus(n,m);
                line = br.readLine(); // Read a row of data at a time
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
}
