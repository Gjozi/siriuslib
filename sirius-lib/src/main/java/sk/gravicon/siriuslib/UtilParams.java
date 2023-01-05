package sk.gravicon.siriuslib;

import org.apache.commons.configuration2.Configuration;
import org.slf4j.Logger;

public class UtilParams {
	private  Logger logger;
	private  Configuration config;
	public UtilParams(Configuration config) {
		this.config=config;
	}
	public UtilParams(Logger logger,Configuration config) {
		this.logger=logger;
		this.config=config;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public Configuration getConfig() {
		return config;
	}
	public void setConfig(Configuration config) {
		this.config = config;
	}
	

}
