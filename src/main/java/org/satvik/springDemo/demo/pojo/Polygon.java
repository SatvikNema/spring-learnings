package org.satvik.springDemo.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Polygon implements Shape{

    @Override
    public void draw() {
        System.out.println("This is polygon!");
    }
}
