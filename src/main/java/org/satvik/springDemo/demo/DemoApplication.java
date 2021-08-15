package org.satvik.springDemo.demo;

import org.satvik.springDemo.demo.dao.JdbcDaoImpl2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		Shape shape = (Shape) context.getBean("triangle");
//		shape.draw();
//		System.out.println("---------------------");

//		Shape shape = (Shape) context.getBean("circle_lol");
//		shape.draw();
//
//		String message = context.getMessage("greeting", null, "greeting message not found!", null);
//		System.out.println("greeting message: "+message);
//
//		FactoryService factory = new FactoryService();
//
//		ShapeService service = (ShapeService) factory.getBean("shapeService");
//		service.getCircle();

//		int x = service.getTriangle().getA().getY();
//		service.displayDetails();
//		DaoService daoService = new DaoService();
//		daoService.getCircle(1);

//		CircleTemp temp = new JdbcDaoImpl().getCircleTemp(1);
//		System.out.println(temp.toString());
//		DaoService service = (DaoService) context.getBean("daoService");
//		service.getCircle(1);
//
//		service.getCount();
//		service.getCircleTempJdbc(1);
//		service.insertCircle(new CircleTemp(3, "Third Circle"));
		JdbcDaoImpl2 daoImpl2 = context.getBean("jdbcDaoImpl2", JdbcDaoImpl2.class);
		daoImpl2.getCount();
	}
}
