/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.testing;

/**
 * The DataLoader class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T> The target type into which data will be loaded
 */
public class DataLoader<T> {

	/**
	 * Load data from a JSON file into an object of the specified type.
	 * This implementation assumes that the data file is on the classpath in the same
	 * directory as the data object class.
	 *
	 * @param fileName Name of the JSON file containing data to load
	 * @return An object of the given type, populated with data from the file.
	 */
	public T loadFromJsonFile(String fileName) {
		T dataObj = null;

		return dataObj;
	}

}
