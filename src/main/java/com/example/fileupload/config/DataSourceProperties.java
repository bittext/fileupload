package com.example.fileupload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("datasource")
public class DataSourceProperties {
	
	private String url;
	private String userName;
	private String password;
	private String driverClassName;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	@Override
	public String toString() {
		return String.format("DataSource{url:'%s', userName:'%s', password:'%s',driverclassname='%s'}",
				url, userName, password, driverClassName);
	}
	
}
