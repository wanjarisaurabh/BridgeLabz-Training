package com.artexpo;

public class Artist {
    private String name;
    private String registrationTime;
    private String artCategory;
    
    public Artist(String name,String time,String category){
        this.name=name;
        this.registrationTime=time;
        this.artCategory=category;
    }
    
    public String getName(){
        return name;
    }
    
    public String getRegistrationTime(){
        return registrationTime;
    }
    
    public String getArtCategory(){
        return artCategory;
    }
}
