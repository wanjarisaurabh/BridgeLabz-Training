package com.stackqueuehashmap.stackqueue;

import java.util.Stack;

public class Q3_StockSpanProblem {
    
    // Calculate span for each day
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            // Pop elements while stack is not empty and 
            // top element's price is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // If stack is empty, all previous prices were smaller
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Span is difference between current index and top of stack
                span[i] = i - stack.peek();
            }
            
            // Push current index to stack
            stack.push(i);
        }
        
        return span;
    }
    
    public static void main(String[] args) {
        Q3_StockSpanProblem solution = new Q3_StockSpanProblem();
        
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = solution.calculateSpan(prices);
        
        System.out.println("Stock Prices:");
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Day " + (i+1) + ": Price = " + prices[i] + ", Span = " + span[i]);
        }
    }
}
