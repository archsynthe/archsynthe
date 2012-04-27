/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

import com.archsynthe.platform.annotation.configuration.ConfigProp;
import com.archsynthe.platform.annotation.configuration.Configurable;
import com.archsynthe.platform.configuration.ConfigurationService;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConfigurationExtension class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigurationExtension implements Extension {

	private static Logger logger = Logger.getLogger(ConfigurationExtension.class.getName(), ConfigurationExtension.class.getName());

	private static final String DEFAULT_CONFIG_VERSION = "1.0.0";

	public <T> void processInjectionTarget(@Observes ProcessInjectionTarget<T> processInjectionTarget) {

		// Retrieve annotated type
		AnnotatedType<T> annotatedType = processInjectionTarget.getAnnotatedType();

		// Check if @Configurable annotation is present
		if (annotatedType.isAnnotationPresent(Configurable.class)) {

			// Log annotation found
			logger.log(Level.INFO, "configurable.annotation.found", new Object[]{annotatedType.getJavaClass().getName()});

			// Retrieve annotation
			Configurable configurableAnnotation = annotatedType.getAnnotation(Configurable.class);

			// Retrieve config name
			String configName = configurableAnnotation.name();

			// Check for empty config name
			if (configName.isEmpty()) {

				// Default to fully-qualified class name
				configName = annotatedType.getJavaClass().getName();

				// Log the defaulted value
				logger.log(Level.INFO, "configurable.annotation.name.empty", new Object[]{annotatedType.getJavaClass().getName(), configName});
			}

			// Retrieve config version
			String configVersion = configurableAnnotation.version();

			// Check for empty config version
			if (configVersion.isEmpty()) {

				// Set default config version
				configVersion = DEFAULT_CONFIG_VERSION;

				// Log the defaulted value
				logger.log(Level.INFO, "configurable.annotation.version.empty", new Object[]{annotatedType.getJavaClass().getName(), configVersion});
			}

			final List<ConfigPropSpec> configPropSpecs = new ArrayList<ConfigPropSpec>();

			// Process field configuration properties
			final Set<AnnotatedField<? super T>> annotatedFields = annotatedType.getFields();
			for (AnnotatedField<? super T> annotatedField : annotatedFields) {

				// Check if @ConfigProp annotation is present
				if (annotatedField.isAnnotationPresent(ConfigProp.class)) {

					// Retrieve field name
					String fieldName = annotatedField.getJavaMember().getName();

					// Log annotation found
					logger.log(Level.INFO, "configprop.annotation.found", new Object[]{ConfigPropSpec.InjectionType.FIELD,fieldName});

					// Retrieve annotation
					ConfigProp configPropAnnotation = annotatedField.getAnnotation(ConfigProp.class);

					// Retrieve config prop name
					String configPropName = configPropAnnotation.name();
					if (configPropName.isEmpty()) {

						// Default to field name
						configPropName = fieldName;

						// Log the defaulted value
						logger.log(Level.INFO, "configprop.annotation.name.empty", new Object[]{ConfigPropSpec.InjectionType.FIELD,fieldName,configPropName});

					}

					// Create configuration property spec
					ConfigPropSpec configPropSpec = new ImmutableConfigPropSpec(ConfigPropSpec.InjectionType.FIELD, configPropName);

					// Add configuration property spec to the list
					configPropSpecs.add(configPropSpec);

				}
			}

			// Process method configuration properties
			final Set<AnnotatedMethod<? super T>> annotatedMethods = annotatedType.getMethods();
			for (AnnotatedMethod<? super T> annotatedMethod : annotatedMethods) {

				// Check if @ConfigProp annotation is present
				if (annotatedMethod.isAnnotationPresent(ConfigProp.class)) {

					// Retrieve method name
					String methodName = annotatedMethod.getJavaMember().getName();

					// Log annotation found
					logger.log(Level.INFO, "configprop.annotation.found", new Object[]{ConfigPropSpec.InjectionType.METHOD,methodName});

					// Retrieve annotation
					ConfigProp configPropAnnotation = annotatedMethod.getAnnotation(ConfigProp.class);

					// Retrieve config prop name
					String configPropName = configPropAnnotation.name();
					if (configPropName.isEmpty()) {

						// Default to method name
						configPropName = methodName;

						// Log the defaulted value
						logger.log(Level.INFO, "configprop.annotation.name.empty", new Object[]{ConfigPropSpec.InjectionType.METHOD,methodName,configPropName});

					}

					// Create configuration property spec
					ConfigPropSpec configPropSpec = new ImmutableConfigPropSpec(ConfigPropSpec.InjectionType.METHOD, configPropName);

					// Add configuration property spec to the list
					configPropSpecs.add(configPropSpec);

				}
			}

			// Create configurable spec
			final ConfigurableSpec configurableSpec = new ImmutableConfigurableSpec(configName,configVersion,configPropSpecs);

			// Lookup configuration service
			ConfigurationService configurationService = null;
			for (ConfigurationService service : ServiceLoader.load(ConfigurationService.class)) {
				// TODO: Select service implementation based on capability spec
				if (service != null) {
					configurationService = service;
					break;
				}
			}

			if (configurationService == null) {
				logger.log(Level.WARNING, "ConfigurationService.implementation.empty");
			} else {
				logger.log(Level.INFO, "ConfigurationService.implementation.found", new Object[]{configurationService.getClass().getName()});
			}

			// Decorate the injection target
			final InjectionTarget<T> delegate = processInjectionTarget.getInjectionTarget();
			InjectionTarget<T> wrapper = new ConfigurableInjectionTarget<T>(annotatedType, delegate, configurationService, configurableSpec);

			// Replace the injection target with the decorated copy
			processInjectionTarget.setInjectionTarget(wrapper);
		}
	}

}
