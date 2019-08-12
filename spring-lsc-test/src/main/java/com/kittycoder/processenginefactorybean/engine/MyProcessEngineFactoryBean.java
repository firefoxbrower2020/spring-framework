package com.kittycoder.processenginefactorybean.engine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by shucheng on 2019-8-12 下午 21:10
 * 模拟Activiti6的ProcessEngineFacotoryBean
 */
public class MyProcessEngineFactoryBean implements FactoryBean<MyProcessEngine>, DisposableBean, ApplicationContextAware {

	protected MyProcessEngineConfigurationImpl myProcessEngineConfiguration;
	protected MyProcessEngine processEngine;

	private ApplicationContext applicationContext;

	@Override
	public void destroy() throws Exception {
		if (processEngine != null) {
			processEngine.close();
		}
	}

	@Override
	public MyProcessEngine getObject() throws Exception {
		this.processEngine = myProcessEngineConfiguration.buildProcessEngine();
		return this.processEngine;
	}

	@Override
	public Class<?> getObjectType() {
		return MyProcessEngine.class;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void setMyProcessEngineConfiguration(MyProcessEngineConfigurationImpl myProcessEngineConfiguration) {
		this.myProcessEngineConfiguration = myProcessEngineConfiguration;
	}
}
