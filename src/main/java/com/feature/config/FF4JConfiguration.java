package com.feature.config;

import javax.sql.DataSource;

import org.ff4j.FF4j;
import org.ff4j.store.JdbcFeatureStore;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfiguration {
	
	@Bean
	public FF4j getFF4j() {		
		FF4j featureFlip = new FF4j();
		featureFlip.setFeatureStore(new JdbcFeatureStore(getDataSource()));
		return featureFlip;
	}
	
	@Bean 
	public DataSource getDataSource(){
		return DataSourceBuilder
		        .create()
		        .build();
	}
	
	    @Bean
	    public ServletRegistrationBean ff4jDispatcherServletRegistrationBean(FF4jDispatcherServlet ff4jDispatcherServlet) {
	        return new ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*");
	    }

}
