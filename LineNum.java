import java.util.Iterator;
import java.util.NoSuchElementException;


public class LineNum<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;   // the item in the node
        private Node next;   // reference to next item
    }

    /**
     * Initializes an empty queue.
     */
    public LineNum() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Add the item to the queue.
     *
     * @param item the item to enqueue
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    /**
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LineNum<String> queue = new LineNum<String>();
		int n = Integer.parseInt(args[0]);
		//n will take the input provided in args, and will convert it into an integer.
		while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
			queue.enqueue(item);
		}
		//The while statement will take any input in the Standard Input and will place it in a queue until the user exits the Standard Input.
		for (int i = 1; i < n; i++) {
			queue.dequeue();
			//The for loop will go through each item in the queue until it finds the item in the queue described by n as the nth variable from the first.
		}
        
		StdOut.print(n + " from the first is ");
		StdOut.println(queue.dequeue());
		//The two print statements will occur. The first will take the integer given and combine it with a string statement. The second will print out the current variable in the queue defined by the user as n.
    }
}