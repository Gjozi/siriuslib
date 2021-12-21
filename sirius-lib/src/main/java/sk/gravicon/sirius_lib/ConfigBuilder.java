package sk.gravicon.sirius_lib;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;



public class ConfigBuilder {
	private static ConfigBuilder ca = null;
	private static Configuration config;
	//private ConfigValues configValues= new ConfigValues();
	
	private ConfigBuilder() {
	}

	public static ConfigBuilder getInstance(String fileName) {
		if (ca == null) {
			ca = new ConfigBuilder();
		}
		Configurations configs = new Configurations();
		try {
			config = configs.properties(new File(fileName));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// access configuration properties
		return ca;
	}
	public  Configuration getConfig() {
		return config;
	}
	

//	public  ConfigApp getCa() {
//		return ca;
//	}


	
//	public ConfigValues getConfigValues() {
//		this.loadValues();
//		return configValues;
//	}
//	
//	private void loadValues() {
//		configValues.loadConfig(getConfig());
//	}
}

