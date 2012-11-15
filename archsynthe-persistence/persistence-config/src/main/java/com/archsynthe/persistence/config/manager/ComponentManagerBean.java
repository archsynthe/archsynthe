/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.manager;

import com.archsynthe.persistence.config.model.Component;
import com.archsynthe.persistence.config.model.ConfigProp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * The ComponentManagerBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ComponentManagerBean implements ComponentManager {

	@PersistenceContext(unitName = "ConfigDS")
	EntityManager entityManager;

	@Override
	public Component lookup(String name, String version) {
		Query query = entityManager.createQuery("select object(c) from Component c where c.name = :name and c.version = :version");
		query.setParameter("name",name);
		query.setParameter("version",version);
		return (Component) query.getSingleResult();
	}

	@Override
	public Component create(String name, String version) {
		entityManager.getTransaction().begin();
		Component component = new Component();
		entityManager.persist(component);
		component.setName(name);
		component.setVersion(version);
		entityManager.getTransaction().commit();
		return component;
	}

	@Override
	public ConfigProp addConfigProp(Component component, String name) {
		entityManager.getTransaction().begin();
		ConfigProp prop = new ConfigProp();
		entityManager.persist(prop);
		prop.setName(name);
		prop.setComponent(component);
		component.getConfigProps().add(prop);
		entityManager.getTransaction().commit();
		return prop;
	}
}
