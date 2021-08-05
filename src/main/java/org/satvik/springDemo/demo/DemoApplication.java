package org.satvik.springDemo.demo;

import org.satvik.springDemo.demo.pojo.Point;
import org.satvik.springDemo.demo.pojo.Shape;
import org.satvik.springDemo.demo.pojo.Triangle;
import org.satvik.springDemo.demo.service.FactoryService;
import org.satvik.springDemo.demo.service.ShapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class DemoApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		Shape shape = (Shape) context.getBean("triangle");
//		shape.draw();
//		System.out.println("---------------------");

//		Shape shape = (Shape) context.getBean("circle_lol");
//		shape.draw();
//
//		String message = context.getMessage("greeting", null, "greeting message not found!", null);
//		System.out.println("greeting message: "+message);


		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		FactoryService factory = new FactoryService();

		ShapeService service = (ShapeService) factory.getBean("shapeService");
		service.getCircle();

//		int x = service.getTriangle().getA().getY();
//		service.displayDetails();

	}
}
