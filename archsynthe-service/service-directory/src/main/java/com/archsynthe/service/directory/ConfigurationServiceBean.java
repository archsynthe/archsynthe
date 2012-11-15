/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.directory;

import com.archsynthe.persistence.config.manager.ComponentManager;
import com.archsynthe.persistence.config.model.Component;
import com.archsynthe.persistence.config.model.ConfigProp;
import com.archsynthe.platform.configuration.ConfigurationService;
import com.archsynthe.platform.configuration.cdi.ConfigurableSpec;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * The ConfigurationServiceBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigurationServiceBean implements ConfigurationService {

	@Inject
	ComponentManager componentManager;

	@Override
	public Map<String, Object> lookupConfigPropValues(ConfigurableSpec spec) {
		Map<String,Object> propMap = new HashMap<String,Object>();
		Component component = componentManager.lookup(spec.getName(),spec.getVersion());
		for (ConfigProp prop : component.getConfigProps()) {
			propMap.put(prop.getName(),prop.getValue());
		}
		return propMap;
	}

}
