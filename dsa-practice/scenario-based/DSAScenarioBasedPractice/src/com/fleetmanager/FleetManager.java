package com.fleetmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class FleetManager {
    
    public static ArrayList<Vehicle> mergeSort(ArrayList<Vehicle> vehicles){
        if(vehicles.size()<=1){
            return vehicles;
        }
        
        int mid=vehicles.size()/2;
        ArrayList<Vehicle> left=new ArrayList<>();
        ArrayList<Vehicle> right=new ArrayList<>();
        
        for(int i=0;i<mid;i++){
            left.add(vehicles.get(i));
        }
        for(int i=mid;i<vehicles.size();i++){
            right.add(vehicles.get(i));
        }
        
        left=mergeSort(left);
        right=mergeSort(right);
        
        return merge(left,right);
    }
    
    public static ArrayList<Vehicle> merge(ArrayList<Vehicle> left,ArrayList<Vehicle> right){
        ArrayList<Vehicle> result=new ArrayList<>();
        int i=0,j=0;
        
        while(i<left.size() && j<right.size()){
            if(left.get(i).getMileage()<=right.get(j).getMileage()){
                result.add(left.get(i));
                i++;
            }else{
                result.add(right.get(j));
                j++;
            }
        }
        
        while(i<left.size()){
            result.add(left.get(i));
            i++;
        }
        
        while(j<right.size()){
            result.add(right.get(j));
            j++;
        }
        
        return result;
    }
    
    public static void displayVehicles(ArrayList<Vehicle> vehicles){
        System.out.println("\n=== Maintenance Schedule ===");
        for(int i=0;i<vehicles.size();i++){
            Vehicle v=vehicles.get(i);
            System.out.println((i+1)+". "+v.getVehicleId()+" | Mileage: "+v.getMileage()+" km | Depot: "+v.getDepotName());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Vehicle> allVehicles=new ArrayList<>();
        
        System.out.print("How many depots? ");
        int numDepots=sc.nextInt();
        sc.nextLine();
        
        for(int d=1;d<=numDepots;d++){
            System.out.println("\n--- Depot "+d+" ---");
            System.out.print("Depot name: ");
            String depotName=sc.nextLine();
            System.out.print("How many vehicles in this depot? ");
            int n=sc.nextInt();
            sc.nextLine();
            
            for(int i=0;i<n;i++){
                System.out.print("Vehicle ID: ");
                String id=sc.nextLine();
                System.out.print("Mileage (km): ");
                int mileage=sc.nextInt();
                sc.nextLine();
                
                allVehicles.add(new Vehicle(id,mileage,depotName));
            }
        }
        
        System.out.println("\nBefore sorting:");
        displayVehicles(allVehicles);
        
        allVehicles=mergeSort(allVehicles);
        
        System.out.println("\nAfter merge sort (by mileage):");
        displayVehicles(allVehicles);
        
        sc.close();
    }
}
