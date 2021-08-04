package org.satvik.springDemo.demo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent.getSource().getClass().getName().equals("org.satvik.springDemo.demo.pojo.Triangle")) {
            System.out.println(applicationEvent.toString());
        }

    }
}
