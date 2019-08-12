package com.kittycoder.processenginefactorybean.engine;

/**
 * Created by shucheng on 2019-8-12 下午 21:22
 */
public class MyProcessEngineImpl implements MyProcessEngine {

	@Override
	public String getName() {
		return "MyProcessEngineImpl";
	}

	@Override
	public void close() {
		System.out.println("关闭流程引擎");
	}
}
