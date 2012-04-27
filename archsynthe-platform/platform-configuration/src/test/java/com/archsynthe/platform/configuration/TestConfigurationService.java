/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration;

import com.archsynthe.platform.configuration.cdi.ConfigurableSpec;

import java.util.HashMap;
import java.util.Map;

/**
 * The TestConfigurationService class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestConfigurationService implements ConfigurationService {

	@Override
	public Map<String, Object> lookupConfigPropValues(ConfigurableSpec spec) {
		Map<String, Object> bindings = new HashMap<String, Object>();
		bindings.put("component.test.property","SUCCESS!");
		return bindings;
	}
}
