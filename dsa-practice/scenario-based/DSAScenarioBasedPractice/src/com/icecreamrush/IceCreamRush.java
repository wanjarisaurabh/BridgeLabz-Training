package com.icecreamrush;

import java.util.Scanner;

public class IceCreamRush {
    
    public static void bubbleSort(IceCreamFlavor[] flavors){
        int n=flavors.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(flavors[j].getSalesCount()<flavors[j+1].getSalesCount()){
                    //swap
                    IceCreamFlavor temp=flavors[j];
                    flavors[j]=flavors[j+1];
                    flavors[j+1]=temp;
                }
            }
        }
    }
    
    public static void displayFlavors(IceCreamFlavor[] flavors){
        System.out.println("\n--- Ice Cream Sales Report ---");
        for(int i=0;i<flavors.length;i++){
            System.out.println((i+1)+". "+flavors[i].getName()+" - "+flavors[i].getSalesCount()+" sales");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("How many flavors do you have? ");
        int n=sc.nextInt();
        sc.nextLine();
        
        IceCreamFlavor[] flavors=new IceCreamFlavor[n];
        
        System.out.println("\nEnter flavor details:");
        for(int i=0;i<n;i++){
            System.out.print("Flavor "+(i+1)+" name: ");
            String name=sc.nextLine();
            System.out.print("Sales count: ");
            int sales=sc.nextInt();
            sc.nextLine();
            flavors[i]=new IceCreamFlavor(name,sales);
        }
        
        System.out.println("\nBefore sorting:");
        displayFlavors(flavors);
        
        bubbleSort(flavors);
        
        System.out.println("\nAfter sorting by popularity:");
        displayFlavors(flavors);
        
        sc.close();
    }
}
