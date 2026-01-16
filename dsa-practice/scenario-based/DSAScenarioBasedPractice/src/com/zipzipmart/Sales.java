package com.zipzipmart;

import java.time.LocalDate;

//the sale class for records
public class Sales {
	String product;
	LocalDate saleDate;
	double amount;
	
	
	//the constructor
	public Sales(String product,LocalDate saleDate,double amount) {
		this.product=product;
		this.saleDate=saleDate;
		this.amount=amount;
		
	}
	
	//merging method
	private  static void merge(Sales[] documents,int low,int mid,int high) {
		//determining size that will be needed
		int size1=mid-low+1;
		int size2=high-mid;
		
		//the first array
		Sales arr1[]=new Sales[size1];
		System.arraycopy(documents, low, arr1, 0, size1);
		
		//second half of arrray
	    Sales arr2[]=new Sales[size2];
	    System.arraycopy(documents,mid+1 , arr2, 0, size2);
	    
	    //indexes for traversal
	    int i=0;
	    int j=0;
	    
	    while(i<size1 && j<size2) {
	    	if(arr1[i].saleDate.isBefore(arr2[j].saleDate)) {
	    		documents[low]=arr1[i];
	    		i++;
	    		low++;
	    	}
	    	else  if(arr1[i].saleDate.isAfter(arr2[j].saleDate)) {
	    		documents[low]=arr2[j];
	    		j++;
	    		low++;
	    	}
	    	else {
	    		if(arr1[i].amount<=arr2[j].amount) {
	    			documents[low]=arr1[i];
	    			i++;
	    			low++;
	    		}
	    		else {
	    			documents[low]=arr2[j];
	    			j++;
	    			low++;
	    		}
	    	}
	    }
	    
	    // if further elements from arr1 are left
	    while(i<size1) {
	    	documents[low]=arr1[i];
	    	low++;
	    	i++;
	    }
	    
	    // if further elements from arr2 are left
	    while(j<size2) {
	    	documents[low]=arr2[j];
	    	j++;
	    	low++;
	    }
	    
	    
	}
	
	//calling of merge sort
	private static void mergeSort(Sales[] documents,int low, int high) {
		
		
		if(low>=high) {
			return;
		}
		
		int mid=low+(high-low)/2;
		
		mergeSort(documents,low,mid);
		mergeSort(documents,mid+1,high);
		merge(documents,low,mid,high);
	}
	
	//method to make record
	public static void makeReport(Sales[] documents) {
		mergeSort(documents,0,documents.length-1);
	}

}
