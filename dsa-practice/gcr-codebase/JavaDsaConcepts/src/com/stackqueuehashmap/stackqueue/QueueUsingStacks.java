package com.stackqueuehashmap.stackqueue;

import java.util.Stack;

public class Q1_QueueUsingStacks {
    
    private Stack<Integer> stack1; // for enqueue
    private Stack<Integer> stack2; // for dequeue
    
    public Q1_QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add element to queue
    public void enqueue(int value) {
        stack1.push(value);
    }
    
    // Remove and return front element
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Get front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    public static void main(String[] args) {
        Q1_QueueUsingStacks queue = new Q1_QueueUsingStacks();
        
        // Test the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        
        queue.enqueue(40);
        
        System.out.println("Peek: " + queue.peek());       // 30
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Dequeue: " + queue.dequeue()); // 40
    }
}
