package dk.tree;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import dk.main.Show;
public class StructExample extends Show {

	public static void main(String[] args) {
		//use of stack
		Stack<String> stack = new Stack<String>();
		stack.push("My");
		stack.push("Stack");
		show(stack.peek());
		show(stack.pop());
		show(stack.search("My"));
		show(stack.pop());
		//use of LinkedList
		List<String> list = new LinkedList<String>();
		list.add("My");
		list.add("Lover");
		for(String s:list){
			show(s);
		}
		//Queue
		Queue<String> q = new LinkedList<String>();
		q.offer("Hello");
		q.offer(" ");
		q.offer("world!");
		show(q.size());
		String str;
		while((str = q.poll())!=null){
            System.out.print(str);
        }
		//use of vector
		  show();
	      Vector<Number> v = new Vector<Number>(3, 2);
	      System.out.println("Initial size: " + v.size());
	      System.out.println("Initial capacity: " +
	      v.capacity());
	      v.addElement(new Integer(1));
	      v.addElement(new Integer(2));
	      v.addElement(new Integer(3));
	      v.addElement(new Integer(4));
	      System.out.println("Capacity after four additions: " +
	          v.capacity());

	      v.addElement(new Double(5.45));
	      System.out.println("Current capacity: " +
	      v.capacity());
	      v.addElement(new Double(6.08));
	      v.addElement(new Integer(7));
	      System.out.println("Current capacity: " +
	      v.capacity());
	      v.addElement(new Float(9.4));
	      v.addElement(new Integer(10));
	      System.out.println("Current capacity: " +
	      v.capacity());
	      v.addElement(new Integer(11));
	      v.addElement(new Integer(12));
	      System.out.println("First element: " +
	         (Integer)v.firstElement());
	      System.out.println("Last element: " +
	         (Integer)v.lastElement());
	      if(v.contains(new Integer(3)))
	         System.out.println("Vector contains 3.");
	      // enumerate the elements in the vector.
	      Enumeration<Number> vEnum = v.elements();
	      System.out.println("Elements in vector:");
	      while(vEnum.hasMoreElements())
	         System.out.print(vEnum.nextElement() + " ");
	      System.out.println();

	}

}
