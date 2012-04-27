/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.annotation.configuration;

import java.lang.annotation.*;

/**
 * The Configurable class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProp {

	String name() default "";

}
