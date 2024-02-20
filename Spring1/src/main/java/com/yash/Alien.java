package com.yash;

public class Alien {

    private int age;
    private Laptop lap;
    public void code(){
        System.out.println("Coding");
        lap.compile();
    }

    public void setAge(int age){
        System.out.println("Setter Called") ;
        this.age =age;
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
