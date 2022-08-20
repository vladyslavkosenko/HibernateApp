package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.demo");
		ProductDao productDao = context.getBean("jpaContainerProductDao", ProductDao.class);
//		ProductDao productDao = context.getBean("jpaApplicationProductDao", ProductDao.class);
//        ProductDao productDao = context.getBean("hibernateProductDao", ProductDao.class);

        Product product = new Product();
        product.setName("Mars");
        product.setPrice(BigDecimal.valueOf(10));
        productDao.create(product);

        List<Product> products = productDao.readAll();

        System.out.println(products);
    }

}
