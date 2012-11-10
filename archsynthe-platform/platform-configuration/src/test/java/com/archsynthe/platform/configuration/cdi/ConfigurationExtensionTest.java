/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

import com.archsynthe.platform.annotation.configuration.ConfigProp;
import com.archsynthe.platform.annotation.configuration.Configurable;
import com.archsynthe.platform.configuration.ConfigurableComponentWithNameAndVersion;
import com.archsynthe.platform.configuration.ConfigurableComponentWithNameNoVersion;
import com.archsynthe.platform.configuration.ConfigurableComponentWithVersionNoName;
import com.archsynthe.platform.configuration.ConfigurationService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * The ConfigurationExtensionTest class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(Arquillian.class)
public class ConfigurationExtensionTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
				.addPackage(ConfigurationService.class.getPackage())
				.addPackage(ConfigurationExtension.class.getPackage())
				.addClasses(
						Configurable.class,
						ConfigProp.class)
				.addClasses(
						ConfigurableComponentWithNameNoVersion.class,
						ConfigurableComponentWithNameAndVersion.class,
						ConfigurableComponentWithVersionNoName.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return archive;
	}

	@Inject
	private ConfigurableComponentWithNameAndVersion componentWithNameAndVersion;

	@Inject
	private ConfigurableComponentWithNameNoVersion componentWithNameNoVersion;

	@Inject
	private ConfigurableComponentWithVersionNoName componentWithVersionNoName;

	@Test
	public void should_configure_component_with_name_and_version() throws Exception {

		assertNotNull(componentWithNameAndVersion);
		assertTrue(componentWithNameAndVersion.getClass().isAnnotationPresent(Configurable.class));

		Configurable configurableAnnotation = componentWithNameAndVersion.getClass().getAnnotation(Configurable.class);
		assertNotNull(configurableAnnotation);

		String configName = configurableAnnotation.name();
		assertNotNull(configName);
		assertFalse(configName.isEmpty());

		String configVersion = configurableAnnotation.version();
		assertNotNull(configVersion);
		assertFalse(configName.isEmpty());

		assertEquals("SUCCESS!",componentWithNameAndVersion.getComponentTestProperty());

	}

	@Test
	public void should_configure_component_with_name_and_default_version() throws Exception {

		assertNotNull(componentWithNameNoVersion);

		Configurable configurableAnnotation = componentWithNameNoVersion.getClass().getAnnotation(Configurable.class);
		assertNotNull(configurableAnnotation);

		String configName = configurableAnnotation.name();
		assertNotNull(configName);
		assertFalse(configName.isEmpty());

		String configVersion = configurableAnnotation.version();
		assertNotNull(configVersion);
		assertTrue(configVersion.isEmpty());

		assertEquals("SUCCESS!",componentWithNameNoVersion.getComponentTestProperty());

	}

	@Test
	public void should_configure_component_with_version_and_default_name() throws Exception {

		assertNotNull(componentWithVersionNoName);

		Configurable configurableAnnotation = componentWithVersionNoName.getClass().getAnnotation(Configurable.class);
		assertNotNull(configurableAnnotation);

		String configName = configurableAnnotation.name();
		assertNotNull(configName);
		assertTrue(configName.isEmpty());

		String configVersion = configurableAnnotation.version();
		assertNotNull(configVersion);
		assertFalse(configVersion.isEmpty());

		assertEquals("SUCCESS!",componentWithVersionNoName.getComponentTestProperty());

	}

}
