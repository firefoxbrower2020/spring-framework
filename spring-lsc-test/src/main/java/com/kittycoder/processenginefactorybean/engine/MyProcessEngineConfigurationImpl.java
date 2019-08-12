package com.kittycoder.processenginefactorybean.engine;

/**
 * Created by shucheng on 2019-8-12 下午 21:28
 */
public class MyProcessEngineConfigurationImpl extends MyProcessEngineConfiguration {

	@Override
	public MyProcessEngine buildProcessEngine() {
		System.out.println("================流程引擎配置前置初始化=================");
		MyProcessEngineImpl processEngine = new MyProcessEngineImpl();
		System.out.println("================流程引擎配置后置初始化=================");
		return processEngine;
	}
}
