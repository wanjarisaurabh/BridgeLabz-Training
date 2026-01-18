package com.artexpo;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtExpo {
    
    private ArrayList<Artist> artists;
    
    public ArtExpo(){
        artists=new ArrayList<>();
    }
    
    public void registerArtist(Artist artist){
        artists.add(artist);
        
        //insertion sort by time
        for(int i=artists.size()-1;i>0;i--){
            String currentTime=artists.get(i).getRegistrationTime();
            String previousTime=artists.get(i-1).getRegistrationTime();
            
            if(currentTime.compareTo(previousTime)<0){
                Artist temp=artists.get(i);
                artists.set(i,artists.get(i-1));
                artists.set(i-1,temp);
            }else{
                break;
            }
        }
    }
    
    public void showRegistrations(){
        if(artists.isEmpty()){
            System.out.println("No artists registered yet");
            return;
        }
        System.out.println("\n=== Artist Registration List (By Time) ===");
        for(int i=0;i<artists.size();i++){
            Artist a=artists.get(i);
            System.out.println((i+1)+". "+a.getName()+" | "+a.getArtCategory()+" | Registered at: "+a.getRegistrationTime());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArtExpo expo=new ArtExpo();
        
        while(true){
            System.out.println("\n--- Art Expo Registration ---");
            System.out.println("1. Register Artist");
            System.out.println("2. View All Registrations");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");
            
            int opt=sc.nextInt();
            sc.nextLine();
            
            if(opt==1){
                System.out.print("Artist name: ");
                String name=sc.nextLine();
                System.out.print("Registration time (HH:MM): ");
                String time=sc.nextLine();
                System.out.print("Art category: ");
                String category=sc.nextLine();
                
                Artist artist=new Artist(name,time,category);
                expo.registerArtist(artist);
                System.out.println("Artist registered successfully!");
            }
            else if(opt==2){
                expo.showRegistrations();
            }
            else if(opt==3){
                System.out.println("Closing registration system...");
                break;
            }
        }
        
        sc.close();
    }
}
