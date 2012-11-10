/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.manager;

import com.archsynthe.persistence.paradigm.model.Attribute;
import com.archsynthe.persistence.paradigm.model.Element;

/**
 * The ParadigmManager interface ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ElementManager {

	Element create(String name);

	void associate(Element element, Attribute attribute);

	void disassociate(Element element, Attribute attribute);

}
