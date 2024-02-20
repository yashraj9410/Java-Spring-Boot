package com.yash.SprinBootBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// using componet annotation we are asking spring to create the object
@Component
public class Alien {

    // automatically get attatched by spring using wiring concept
    @Autowired
    Laptop laptop;
    public void code(){
        laptop.code();
    }
}


// this is example of dependency injection using wiring concept
// we can create multiple layers
