package com.stackqueuehashmap.hashmap;

// Problem: Implement a Custom Hash Map
// Uses separate chaining with linked lists for collision handling
public class Q4_CustomHashMap {

	public static void main(String[] args) {
		System.out.println("=== Testing Custom HashMap ===\n");
		
		MyHashMap map = new MyHashMap();
		
		// Test 1: Insertion
		System.out.println("--- Test 1: Inserting key-value pairs ---");
		map.put("John", 25);
		map.put("Alice", 30);
		map.put("Bob", 35);
		map.put("Diana", 28);
		System.out.println("Inserted 4 entries");
		System.out.println("Size: " + map.size());
		
		System.out.println("\n--- Test 2: Retrieving values ---");
		System.out.println("John's age: " + map.get("John"));
		System.out.println("Alice's age: " + map.get("Alice"));
		System.out.println("Bob's age: " + map.get("Bob"));
		System.out.println("Unknown key: " + map.get("Unknown"));
		
		System.out.println("\n--- Test 3: Updating existing key ---");
		System.out.println("Bob's old age: " + map.get("Bob"));
		map.put("Bob", 40);
		System.out.println("Bob's new age: " + map.get("Bob"));
		
		System.out.println("\n--- Test 4: Check if key exists ---");
		System.out.println("Contains 'Alice': " + map.containsKey("Alice"));
		System.out.println("Contains 'Eve': " + map.containsKey("Eve"));
		
		System.out.println("\n--- Test 5: Removing entries ---");
		System.out.println("Removing Alice...");
		map.remove("Alice");
		System.out.println("Contains 'Alice': " + map.containsKey("Alice"));
		System.out.println("Size after removal: " + map.size());
		
		System.out.println("\n--- Test 6: Display all entries ---");
		map.display();
	}
}

class MyHashMap {
	
	class Node {
		String key;
		int value;
		Node next;
		
		Node(String key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	private Node[] buckets;
	private int capacity;
	private int size;
	
	public MyHashMap() {
		this.capacity = 10;
		this.buckets = new Node[capacity];
		this.size = 0;
	}
	
	private int getBucketIndex(String key) {
		int hashCode = key.hashCode();
		int index = Math.abs(hashCode) % capacity;
		
		return index;
	}
	
	public void put(String key, int value) {
		int bucketIndex = getBucketIndex(key);
		Node head = buckets[bucketIndex];
		
		Node current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			}
			current = current.next;
		}
		
		Node newNode = new Node(key, value);
		newNode.next = head;
		buckets[bucketIndex] = newNode;
		size++;
	}
	
	public int get(String key) {
		int bucketIndex = getBucketIndex(key);
		Node head = buckets[bucketIndex];
		
		Node current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		
		return -1;
	}
	
	public boolean remove(String key) {
		int bucketIndex = getBucketIndex(key);
		Node head = buckets[bucketIndex];
		
		if (head == null) {
			return false;
		}
		
		if (head.key.equals(key)) {
			buckets[bucketIndex] = head.next;
			size--;
			return true;
		}
		
		Node prev = head;
		Node current = head.next;
		
		while (current != null) {
			if (current.key.equals(key)) {
				prev.next = current.next;
				size--;
				return true;
			}
			prev = current;
			current = current.next;
		}
		
		return false;
	}
	
	public boolean containsKey(String key) {
		return get(key) != -1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() {
		System.out.println("HashMap contents:");
		for (int i = 0; i < capacity; i++) {
			if (buckets[i] != null) {
				System.out.print("Bucket " + i + ": ");
				Node current = buckets[i];
				while (current != null) {
					System.out.print("[" + current.key + "=" + current.value + "] -> ");
					current = current.next;
				}
				System.out.println("null");
			}
		}
		System.out.println("Total entries: " + size);
	}
}
