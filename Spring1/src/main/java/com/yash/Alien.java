package com.yash;

public class Alien {

    private int age;
    private Laptop lap;

    public Alien(int age){
        System.out.println("Para constructor called");
        this.age = age;
    }
    public void code(){
        System.out.println("Coding");
        lap.compile();
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public int getAge(){
        return this.age;
    }
}
