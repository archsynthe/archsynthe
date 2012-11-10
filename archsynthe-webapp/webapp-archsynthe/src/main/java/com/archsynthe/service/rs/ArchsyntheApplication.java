/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The ArchsyntheApplication class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@ApplicationPath("/svc")
public class ArchsyntheApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ComponentResource.class);
		classes.add(HeaderResource.class);
		return classes;
	}
}
