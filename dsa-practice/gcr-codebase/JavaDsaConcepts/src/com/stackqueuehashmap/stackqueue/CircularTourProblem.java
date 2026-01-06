package com.stackqueuehashmap.stackqueue;

public class Q5_CircularTourProblem {
    
    // Class to represent a petrol pump
    static class PetrolPump {
        int petrol;
        int distance;
        
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    
    // Find starting point for circular tour
    public int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int currentPetrol = 0;
        int totalPetrol = 0;
        
        for (int i = 0; i < n; i++) {
            int balance = pumps[i].petrol - pumps[i].distance;
            currentPetrol += balance;
            totalPetrol += balance;
            
            // If current petrol becomes negative, this can't be starting point
            if (currentPetrol < 0) {
                start = i + 1; // try next pump as starting point
                currentPetrol = 0;
            }
        }
        
        // If total petrol is negative, tour is not possible
        if (totalPetrol < 0) {
            return -1;
        }
        
        return start;
    }
    
    public static void main(String[] args) {
        Q5_CircularTourProblem solution = new Q5_CircularTourProblem();
        
        // Create petrol pumps: {petrol, distance to next pump}
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        
        int startPoint = solution.findStartingPoint(pumps);
        
        System.out.println("Petrol Pump Details:");
        for (int i = 0; i < pumps.length; i++) {
            System.out.println("Pump " + i + ": Petrol = " + pumps[i].petrol + 
                             ", Distance = " + pumps[i].distance);
        }
        
        if (startPoint == -1) {
            System.out.println("\nCircular tour is not possible");
        } else {
            System.out.println("\nStarting point: Pump " + startPoint);
        }
    }
}
