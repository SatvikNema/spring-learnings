package org.satvik.springDemo.demo.service;

import org.satvik.springDemo.demo.pojo.Circle;
import org.satvik.springDemo.demo.pojo.Triangle;

public class FactoryService {

    public Object getBean(String beanName){
        if(beanName.equals("shapeService")){
            return new ShapeService();
        }
        if(beanName.equals("circle")){
            return new Circle();
        }
        if(beanName.equals("triangle")){
            return new Triangle("hello");
        }
        return null;
    }
}
