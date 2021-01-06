package com.luban;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * 可以放在spring.factories 也可以通过加入容器自动监听到事件
 */
@Component
public class MyListener implements GenericApplicationListener {

	public boolean supportsEventType(ResolvableType resolvableType) {
		System.out.println("-------------------" + resolvableType.getType().toString());
		return true;
	}

	public void onApplicationEvent(ApplicationEvent applicationEvent) {

	}

	public int getOrder() {
		return 0;
	}

}
