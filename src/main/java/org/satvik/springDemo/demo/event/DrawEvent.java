package org.satvik.springDemo.demo.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class DrawEvent extends ApplicationEvent {
    public DrawEvent(Object source) {
        super(source);
    }

    public String toString(){
        return "draw event occurred!";
    }
}
