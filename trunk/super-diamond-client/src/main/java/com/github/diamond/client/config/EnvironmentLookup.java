/**        
 * Copyright (c) 2013 by 苏州科大国创信息技术有限公司.    
 */
package com.github.diamond.client.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.text.StrLookup;

/**
 * <p>
 * A specialized lookup implementation that allows access to environment
 * variables.
 * </p>
 * <p>
 * This implementation relies on {@link EnvironmentConfiguration} to resolve
 * environment variables. It can be used for referencing environment variables
 * in configuration files in an easy way, for instance:
 * 
 * <pre>
 * java.home = ${env:JAVA_HOME}
 * </pre>
 * 
 * </p>
 * <p>
 * {@code EnvironmentLookup} is one of the standard lookups that is registered
 * per default for each configuration.
 * </p>
 * 
 * 简化EnvironmentLookup 处理
 * 
 * @author <a
 *         href="http://commons.apache.org/configuration/team-list.html">Commons
 *         Configuration team</a>
 * @since 1.7
 * @version $Id: EnvironmentLookup.java 1210620 2011-12-05 20:57:31Z oheger $
 */
public class EnvironmentLookup extends StrLookup {
	private final Map<String, String> envMap = new HashMap<String, String>(
			System.getenv());

	/**
	 * Performs a lookup for the specified variable.
	 * 
	 * @param key
	 *            the key to lookup
	 * @return the value of this key or <b>null</b> if it cannot be resolved
	 */
	@Override
	public String lookup(String key) {
		return getString(key);
	}

	public String getString(String key) {
		String s = getString(key, null);
		if (s != null) {
			return s;
		} else {
			return null;
		}
	}

	public String getString(String key, String defaultValue) {
		String value = envMap.get(key);

		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}
}
