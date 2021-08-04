package org.satvik.springDemo.demo.pojo;

import org.satvik.springDemo.demo.event.DrawEvent;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Triangle implements InitializingBean, DisposableBean, Shape, ApplicationEventPublisherAware {

    private int height;
    private String type;

    private Point b;
    private Point c;
    private Point a;

    private ApplicationEventPublisher applicationEventPublisher;

    public Triangle(String type) {
        this.type = type;
    }

    public Triangle(int height) {
        this.height = height;
    }

    public Triangle(int height, String type) {
        this.height = height;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void draw(){
        System.out.println(this.type+" triangle is drawn of height: "+this.height);
        System.out.println("a = ("+this.a.getX()+", "+this.a.getY()+")");
        System.out.println("b = ("+this.b.getX()+", "+this.b.getY()+")");
        System.out.println("c = ("+this.c.getX()+", "+this.c.getY()+")");

        DrawEvent event = new DrawEvent(this);
        applicationEventPublisher.publishEvent(event);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println("called before destroying the Triangle bean!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("called after Triangle bean is set!");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.applicationEventPublisher = publisher;
    }
}
