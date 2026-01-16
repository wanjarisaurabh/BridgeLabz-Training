package com.examcell;

public class Student {
	String name;
	int score;
	String center;
	
	// constructor
	public Student(String name, int score, String center) {
		this.name = name;
		this.score = score;
		this.center = center;
	}
	
	// merge two sorted arrays
	private static void merge(Student[] students, int low, int mid, int high) {
		int size1 = mid - low + 1;
		int size2 = high - mid;
		
		// create temp arrays
		Student[] left = new Student[size1];
		Student[] right = new Student[size2];
		
		// copy data
		System.arraycopy(students, low, left, 0, size1);
		System.arraycopy(students, mid + 1, right, 0, size2);
		
		int i = 0, j = 0, k = low;
		
		// merge in descending order (highest score first)
		while (i < size1 && j < size2) {
			if (left[i].score >= right[j].score) {
				students[k] = left[i];
				i++;
			} else {
				students[k] = right[j];
				j++;
			}
			k++;
		}
		
		// copy remaining elements
		while (i < size1) {
			students[k] = left[i];
			i++;
			k++;
		}
		
		while (j < size2) {
			students[k] = right[j];
			j++;
			k++;
		}
	}
	
	// merge sort
	private static void mergeSort(Student[] students, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			
			mergeSort(students, low, mid);
			mergeSort(students, mid + 1, high);
			merge(students, low, mid, high);
		}
	}
	
	// sort and generate ranks
	public static void generateRanks(Student[] students) {
		mergeSort(students, 0, students.length - 1);
	}
}
