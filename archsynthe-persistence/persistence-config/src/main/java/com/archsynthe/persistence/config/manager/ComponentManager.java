/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.manager;

import com.archsynthe.persistence.config.model.Component;
import com.archsynthe.persistence.config.model.ConfigProp;

/**
 * The ComponentManager interface ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ComponentManager {

	Component lookup(String name, String version);

	Component create(String name, String version);

	ConfigProp addConfigProp(Component component, String name);

}
