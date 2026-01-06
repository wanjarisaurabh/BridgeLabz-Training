package com.stackqueuehashmap.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class Q4_SlidingWindowMaximum {
    
    // Find maximum in each window of size k
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            // Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller elements from back as they are useless
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            
            // Add current element at back
            deque.offerLast(i);
            
            // Add to result when we have first window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Q4_SlidingWindowMaximum solution = new Q4_SlidingWindowMaximum();
        
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] result = solution.maxSlidingWindow(arr, k);
        
        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n\nWindow size: " + k);
        System.out.println("\nMaximum in each window:");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
