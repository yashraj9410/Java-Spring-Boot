package com.yash.SprinBootBasics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Laptop implements Computer {

    @Override
    public void compile(){
        System.out.println("Running in Laptop");
    }
}