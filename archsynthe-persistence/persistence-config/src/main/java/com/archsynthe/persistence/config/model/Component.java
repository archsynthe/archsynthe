package com.archsynthe.persistence.config.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Component class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Component {

	@Id
	private String id;
	private String name;

}
