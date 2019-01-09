package com.archive.susu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//TODO: https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html
//TODO:https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html
//TODO: same as @Configuration @EnableAutoConfiguration @ComponentScan

/**
 * What is the difference between the @ComponentScan and @EnableAutoConfiguration annotations in Spring Boot?
 *
 * @EnableAutoConfiguration annotation tells Spring Boot to "guess" how you will want to configure Spring, based on the jar dependencies that you have added. For example, If HSQLDB is on your classpath, and you have not manually configured any database connection beans, then Spring will auto-configure an in-memory database.
 * @ComponentScan tells Spring to look for other components, configurations, and services in the specified package. Spring is able to auto scan, detect and register your beans or components from pre-defined project package. If no package is specified current class package is taken as the root package.
 * <p>
 * Is it necessary to add these?
 * <p>
 * If you need Spring boot to Auto configure every thing for you @EnableAutoConfiguration is required. You don't need to add it manually, spring will add it internally for you based on the annotation you provide.
 * <p>
 * Actually the @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes.
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

