/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.manager;

import com.archsynthe.persistence.paradigm.model.Element;
import com.archsynthe.persistence.paradigm.model.Paradigm;

/**
 * The ParadigmManagerBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParadigmManagerBean implements ParadigmManager {

	@Override
	public Paradigm create(String name) {
		Paradigm paradigm = new Paradigm();
		paradigm.setName(name);
		return paradigm;
	}

	@Override
	public void associate(Paradigm paradigm, Element element) {
		element.setParadigm(paradigm);
		paradigm.getElements().add(element);
	}

	@Override
	public void disassociate(Paradigm paradigm, Element element) {
		element.setParadigm(null);
		paradigm.getElements().remove(element);
	}

}
