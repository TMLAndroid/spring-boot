package com.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//以war包方式启动
		return super.configure(builder).sources(App.class);
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(App.class);
		ConfigurableApplicationContext context = springApplication.run(args);
//		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//			System.out.println(beanDefinitionName);
//		}

	}

}
