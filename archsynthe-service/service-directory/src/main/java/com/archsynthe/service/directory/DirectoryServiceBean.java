/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.directory;

import com.archsynthe.platform.annotation.configuration.ConfigProp;
import com.archsynthe.platform.annotation.configuration.Configurable;

import javax.annotation.PostConstruct;

/**
 * The DirectoryServiceBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Configurable(name = "com.archsynthe.service.directory", version = "1.0.0")
public class DirectoryServiceBean implements DirectoryService {

	@ConfigProp(name = "directory")
	String directory;

	@PostConstruct
	public void postConstruct() {
		System.out.println("Value of injected property (directory) is: " + directory);
	}

}
