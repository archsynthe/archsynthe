/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.*;

/**
 * 
 * @author James Adams
 * @since 2.0
 */
@Path("/schema")
public class ComponentResource {

	Map<Integer,Component> componentMap = new HashMap<Integer, Component>();

	public ComponentResource() {
		Component component = new Component();
		component.id = 1;
		component.name = "sampleComponent";
		component.label = "Sample Component";
		componentMap.put(1,component);
	}

	@GET
	@Produces("application/json")
	@Path("/components")
	public List<Component> getComponents() {
		Set<Integer> keys = componentMap.keySet();
		List<Component> components = new ArrayList<Component>(keys.size());
		for (Integer key : keys) {
			components.add(componentMap.get(key));
		}
		return components;
	}

	@GET
	@Produces("application/json")
	@Path("/component/{componentId: [0-9]*}")
	public Component getComponent(@PathParam("componentId") Integer componentId) {
		return componentMap.get(componentId);
	}

}