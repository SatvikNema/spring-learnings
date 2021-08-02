package org.satvik.springDemo.demo.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


@Component("circle_lol")
public class Circle implements Shape{

    private Point center;
    private int radius;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void draw() {
        System.out.println("Drawing circle!");
//        System.out.println("center is: ("+center.getX()+","+center.getY()+")");
        System.out.println(messageSource.getMessage("circle.pointMessage"
                , new Object[]{center.getX(), center.getY()}
                , "greeting message not found!"
                , null));
        System.out.println("From circle's method: "+messageSource.getMessage("greeting", null, "greeting message not found!", null));
    }

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("circle_center")
    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int raduis) {
        this.radius = raduis;
    }
}
