package com.yash;

public class Alien {

    private int age;
    public void code(){
        System.out.println("Coding");
    }

    public void setAge(int age){
        System.out.println("Setter Called") ;
        this.age =age;
    }

    public int getAge(){
        return this.age;
    }
}
