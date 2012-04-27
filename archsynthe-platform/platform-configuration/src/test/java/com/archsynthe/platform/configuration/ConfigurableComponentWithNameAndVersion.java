/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration;

import com.archsynthe.platform.annotation.configuration.ConfigProp;
import com.archsynthe.platform.annotation.configuration.Configurable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConfigurableComponentWithNameAndVersion class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Configurable(
		name = "com.archsynthe.platform.configuration.ConfigurableComponentWithNameAndVersion",
		version = "1.0.0"
)
public class ConfigurableComponentWithNameAndVersion {

	private static final Logger logger = Logger.getLogger(ConfigurableComponentWithNameAndVersion.class.getName());

	@ConfigProp(name = "component.test.property")
	private String componentTestProperty;

	public String getComponentTestProperty() {
		return componentTestProperty;
	}

	@PostConstruct
	public void postConstruct() {
		logger.log(Level.INFO, "[POST-CONSTRUCT] @Configurable test object with name={0} and version={1}", new Object[]{"com.archsynthe.platform.configuration.ConfigurableComponentWithNameAndVersion", "1.0.0"});
		logger.log(Level.INFO, "[PROPERTY] component.test.property = {0}", new Object[]{componentTestProperty});
	}

	@PreDestroy
	public void preDestroy() {
		logger.log(Level.INFO, "[PRE-DESTROY] @Configurable test object with name={0} and version={1}", new Object[]{"com.archsynthe.platform.configuration.ConfigurableComponentWithNameAndVersion", "1.0.0"});
	}

}
