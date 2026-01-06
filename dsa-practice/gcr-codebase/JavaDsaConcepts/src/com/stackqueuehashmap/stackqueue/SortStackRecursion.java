package com.stackqueuehashmap.stackqueue;

import java.util.Stack;

public class Q2_SortStackRecursion {
    
    // Sort the stack in ascending order (smallest on top)
    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        // Remove top element
        int top = stack.pop();
        
        // Sort remaining stack
        sortStack(stack);
        
        // Insert the removed element at correct position
        insertAtCorrectPosition(stack, top);
    }
    
    // Insert element at correct position in sorted stack
    private void insertAtCorrectPosition(Stack<Integer> stack, int value) {
        // If stack is empty or value is greater than top, push it
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }
        
        // Remove top and recursively insert value
        int top = stack.pop();
        insertAtCorrectPosition(stack, value);
        
        // Put back the removed element
        stack.push(top);
    }
    
    public static void main(String[] args) {
        Q2_SortStackRecursion sorter = new Q2_SortStackRecursion();
        Stack<Integer> stack = new Stack<>();
        
        // Add elements
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);
        
        System.out.println("Original stack: " + stack);
        
        sorter.sortStack(stack);
        
        System.out.println("Sorted stack: " + stack);
    }
}
