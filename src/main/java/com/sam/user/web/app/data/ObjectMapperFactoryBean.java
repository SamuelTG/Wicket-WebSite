/**
 * 
 */
package com.sam.user.web.app.data;

import org.springframework.beans.factory.FactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

	@Override
	public ObjectMapper getObject() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enableDefaultTyping();
		return objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
