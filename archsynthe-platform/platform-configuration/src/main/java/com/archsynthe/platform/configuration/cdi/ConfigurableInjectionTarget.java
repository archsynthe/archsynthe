/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

import com.archsynthe.platform.annotation.configuration.ConfigProp;
import com.archsynthe.platform.configuration.ConfigurationService;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConfigurableInjectionTarget class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigurableInjectionTarget<T> implements InjectionTarget<T> {

	private static Logger logger = Logger.getLogger(ConfigurableInjectionTarget.class.getName(),ConfigurableInjectionTarget.class.getName());

	private final AnnotatedType<T> annotatedType;
	private final InjectionTarget<T> delegate;
	private final ConfigurationService configurationService;
	private final ConfigurableSpec configurableSpec;

	public ConfigurableInjectionTarget(AnnotatedType<T> annotatedType, InjectionTarget<T> delegate, ConfigurationService configurationService, ConfigurableSpec configurableSpec) {
		this.annotatedType = annotatedType;
		this.delegate = delegate;
		this.configurationService = configurationService;
		this.configurableSpec = configurableSpec;
	}

	@Override
	public void inject(T instance, CreationalContext<T> ctx) {
		delegate.inject(instance, ctx);
	}

	@Override
	public void postConstruct(T instance) {

		// Log configuration service implementation
		if (configurationService == null) {
			logger.log(Level.WARNING, "ConfigurationService.implementation.null");
		} else {
			logger.log(Level.INFO, "ConfigurationService.implementation.found", new Object[]{configurationService.getClass().getName()});
		}

		// Load configuration property bindings from service
		Map<String,Object> propertyBindingMap = configurationService.lookupConfigPropValues(configurableSpec);

		// Inject annotated fields
		for (AnnotatedField<? super T> annotatedField : annotatedType.getFields()) {
			if (annotatedField.isAnnotationPresent(ConfigProp.class)) {
				ConfigProp configPropAnnotation = annotatedField.getAnnotation(ConfigProp.class);
				String propName = configPropAnnotation.name();
				Object valueBinding = propertyBindingMap.get(propName);
				Field field = annotatedField.getJavaMember();
				try {
					field.setAccessible(true);
					annotatedField.getJavaMember().set(instance,valueBinding);
					logger.log(Level.INFO, "field.property.binding", new Object[]{(String)valueBinding,propName});
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		// Inject annotated methods
		for (AnnotatedMethod<? super T> annotatedMethod : annotatedType.getMethods()) {
			if (annotatedMethod.isAnnotationPresent(ConfigProp.class)) {
				ConfigProp configPropAnnotation = annotatedMethod.getAnnotation(ConfigProp.class);
				String propName = configPropAnnotation.name();
				Object valueBinding = propertyBindingMap.get(propName);
				Method method = annotatedMethod.getJavaMember();
				try {
					method.setAccessible(true);
					method.invoke(instance, valueBinding);
					logger.log(Level.INFO, "field.property.binding", new Object[]{(String)valueBinding,propName});
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		// Log before lifecycle
		logger.log(Level.INFO, "postConstruct.before", new Object[]{instance.getClass().getName()});

		// Invoke delegate method
		delegate.postConstruct(instance);

		// Log after lifecycle
		logger.log(Level.INFO,  "postConstruct.after", new Object[]{instance.getClass().getName()});

	}

	@Override
	public void preDestroy(T instance) {

		// Log before lifecycle
		logger.log(Level.INFO,  "preDestroy.before", new Object[]{instance.getClass().getName()});

		// Invoke delegate method
		delegate.preDestroy(instance);

		// Log after lifecycle
		logger.log(Level.INFO,  "preDestroy.after", new Object[]{instance.getClass().getName()});

		// TODO: Clean up resources

	}

	@Override
	public T produce(CreationalContext<T> ctx) {

		logger.log(Level.INFO, "produce.invoked");

		return delegate.produce(ctx);
	}

	@Override
	public void dispose(T instance) {

		logger.log(Level.INFO, "dispose.before", new Object[]{instance.getClass().getName()});

		delegate.dispose(instance);

		logger.log(Level.INFO, "dispose.after", new Object[]{instance.getClass().getName()});
	}

	@Override
	public Set<InjectionPoint> getInjectionPoints() {
		return delegate.getInjectionPoints();
	}
}
