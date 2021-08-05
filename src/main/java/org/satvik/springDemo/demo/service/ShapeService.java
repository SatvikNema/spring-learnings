package org.satvik.springDemo.demo.service;

import org.satvik.springDemo.demo.aspects.Loggable;
import org.satvik.springDemo.demo.pojo.Circle;
import org.satvik.springDemo.demo.pojo.Triangle;

public class ShapeService {
    private Triangle triangle;
    private Circle circle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    @Loggable
    public Circle getCircle() {
        System.out.println("get circle called from shape service");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void displayDetails(){
        this.getCircle().draw();
        System.out.println("----------------------");
//        this.getTriangle().draw();
    }
}
