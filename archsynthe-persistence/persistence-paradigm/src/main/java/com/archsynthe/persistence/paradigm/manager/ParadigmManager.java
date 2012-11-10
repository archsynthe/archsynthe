/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.manager;

import com.archsynthe.persistence.paradigm.model.Element;
import com.archsynthe.persistence.paradigm.model.Paradigm;

/**
 * The ParadigmManager interface ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ParadigmManager {

	Paradigm create(String name);

	void associate(Paradigm paradigm, Element element);

	void disassociate(Paradigm paradigm, Element element);

}
