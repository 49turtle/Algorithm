package day_0228;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PracticeQueue {
	public static void main(String[] args) {
		
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		System.out.println(queue.peek()); 
		
		queue.add(2);
		System.out.println(queue.peek());
		
		queue.add(3);
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		
		
		
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		
		
	}

}
