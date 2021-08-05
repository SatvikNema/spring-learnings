package org.satvik.springDemo.demo.proxy;

import org.satvik.springDemo.demo.aspects.LoggingAspect;
import org.satvik.springDemo.demo.pojo.Circle;
import org.satvik.springDemo.demo.service.ShapeService;

public class ShapeServiceProxy extends ShapeService {
    @Override
    public Circle getCircle() {
        LoggingAspect aspect = new LoggingAspect();
        aspect.someLoggingFunction();
        return super.getCircle();
    }
}
