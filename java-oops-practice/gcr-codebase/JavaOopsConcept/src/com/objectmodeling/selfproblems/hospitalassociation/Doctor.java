package com.objectmodeling.selfproblems.hospitalassociation;

public class Doctor {
    String name;
    Doctor(String name){ this.name = name; }
    void consult(Patient p){
        System.out.println(name + " consulting " + p.name);
    }
}
