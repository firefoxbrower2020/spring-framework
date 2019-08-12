package com.kittycoder.processenginefactorybean.engine;

/**
 * Created by shucheng on 2019-8-12 下午 21:27
 * 流程引擎配置类
 */
public abstract class MyProcessEngineConfiguration {

	protected String processEngineName = "default";
	protected String jdbcDriver = "org.h2.Driver";
	protected String jdbcUrl = "jdbc:h2:tcp://localhost/~/activiti";

	public String getProcessEngineName() {
		return processEngineName;
	}

	public MyProcessEngineConfiguration setProcessEngineName(String processEngineName) {
		this.processEngineName = processEngineName;
		return this;
	}

	public abstract MyProcessEngine buildProcessEngine();

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
}
