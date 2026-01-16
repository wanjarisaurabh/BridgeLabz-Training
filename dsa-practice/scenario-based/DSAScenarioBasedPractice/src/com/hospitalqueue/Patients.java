package com.hospitalqueue;

//pateint class
public class Patients {
	String name;
	int arrivalOrder;
	int criticality;
	
    public Patients(String name,int arrivalOrder,int criticality) {
    	this.criticality=criticality;
    	this.name=name;
    	this.arrivalOrder=arrivalOrder;
    }
}
