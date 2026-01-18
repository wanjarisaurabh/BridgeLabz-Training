package com.icecreamrush;

public class IceCreamFlavor {
    private String name;
    private int salesCount;
    
    public IceCreamFlavor(String name,int sales){
        this.name=name;
        this.salesCount=sales;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSalesCount(){
        return salesCount;
    }
    
    public void setSalesCount(int count){
        this.salesCount=count;
    }
}
