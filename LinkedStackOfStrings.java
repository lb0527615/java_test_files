import java.util.NoSuchElementException;

public class LinkedStackOfStrings {
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper Node class
    private class Node {
        private String item;
        private Node next;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    // number of elements on the stack
    public int size() {
        return n;
    }


    // add an element to the stack
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
	
	
	public static boolean find(String p, String s) {
		//The find() method will determine if the current variable for p matches String s input the user will provided.
		
		if (p.equals(s)) return true;
		//If a match is found, the method will return true, which will execute an if statement in the for loop in main.
		
		else return false;
		//If a match isn't found, the statement will return false and will begin the for loop again with a new value for p.
		
	}

    public static void main(String[] args) {
		String s = args[0];
		//s will take user input given and turn it into a string.
        
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
        //stack is used to call on the input given in Standard Input.
		
		while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
            }
			//The while statement will take any input in the Standard Input and will place it in a stack until the user exits the Standard Input.
			
		int length = stack.size();
		//length will take the current length of the stack's size as it is to create a limit for the for loop.
		
		for (int i = 1; i <= length; i++) {
			String p = stack.pop();
			//The for loop will output the most recently added string in the stack to p each time the loop starts.
			
			boolean result = find(p, s);
			//The find method will conduct using the current string for stack.pop in the loop, and will also using String s for the find formula.
			
			if (result == true) {
				StdOut.println(s + " exists in the linked stack");
				break;
			}
			//The for loop will end early if it finds a match for String s in the stack, and print the above statement.
			else if (stack.isEmpty()) {
				StdOut.println(s + " does not exist in the linked stack");
			}
			//When the for loop runs out of variables in the stack, the else if statement will print the above statement and will exit the loop.
		} 
	}
}