package sk.gravicon.siriuslib;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;



public class ConfigFactory {
	private static ConfigFactory ca = null;
	private static Configuration config;
	private ConfigFactory() {
	}

	public static ConfigFactory getInstance(String fileName) {
		if (ca == null) {
			ca = new ConfigFactory();
		}
		Configurations configs = new Configurations();
		try {
			config = configs.properties(new File(fileName));
		} catch (ConfigurationException e) {

			e.printStackTrace();
		}
		
		// access configuration properties
		return ca;
	}
	public Configuration getConfig() {
		return config;
	}
	
}

