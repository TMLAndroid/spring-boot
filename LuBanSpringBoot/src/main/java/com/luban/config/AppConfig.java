package com.luban.config;


import com.sun.xml.internal.ws.message.stream.StreamHeader;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AppConfig {

	//配置多线程
	@Bean("applicationEventMulticaster")
	public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(BeanFactory beanFactory, ThreadPoolTaskExecutor poolExecutor){
		SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
		simpleApplicationEventMulticaster.setTaskExecutor(poolExecutor);
		return simpleApplicationEventMulticaster;
	}

	@Bean
	public ThreadPoolTaskExecutor poolExecutor(){
		ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
		threadPoolExecutor.setMaxPoolSize(15);
		threadPoolExecutor.setCorePoolSize(10);
		threadPoolExecutor.setQueueCapacity(30);
		threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		threadPoolExecutor.initialize();

		return threadPoolExecutor;
	}

//	@Bean
//	public TomcatServletWebServerFactory servletWebServerFactory(){
//		TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//		tomcatServletWebServerFactory.setPort(8060);
//		return tomcatServletWebServerFactory;
//	}
//
//	//Tomcat Jetty Netty undertow
//	@Bean
//	public WebServerFactoryCustomizer customizer(){
//		WebServerFactoryCustomizer webServerFactory = new WebServerFactoryCustomizer(){
//			//factory 当前正在使用的Web容器factory对象
//			public void customize(WebServerFactory factory) {
//
//				TomcatServletWebServerFactory factory1 = (TomcatServletWebServerFactory) factory;
//				factory1.setPort(8050);
//			}
//
//		};
//		return webServerFactory;
//	}

}
