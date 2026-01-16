package com.hospitalqueue;


public class ApolloHospital {
	
	
	public static void sortByBubble(Patients[] arr) {
		int size=arr.length;
		
		for(int i=0;i<size;i++) {
			boolean swapped=false;
			
			for(int j=0;j<size-1;j++) {
				if(arr[j].criticality>arr[j+1].criticality) {
					Patients temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false) {
				break;
			}
		}
		
		System.out.println("The sorting was successfull");
	}
}
