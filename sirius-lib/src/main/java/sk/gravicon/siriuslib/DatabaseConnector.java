package sk.gravicon.siriuslib;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.commons.configuration2.Configuration;
//import org.slf4j.Logger;

public class DatabaseConnector {
	private final static DatabaseConnector INSTANCE = new DatabaseConnector();
	private static Configuration config;
	private String dbUrl;
	private String dbType;
	private ServerRuntime cayenneRuntime;
	private DatabaseConnector() {
		super();
	}
	private void setDatabase() {
		String username = config.getString("database.username");
		String pwd = config.getString("database.pwd");
		dbType = config.getString("database.type");
		if (dbType.equals("production")) {
			dbUrl = config.getString("database.dburl");
			String serverRuntimeConfig = config.getString("ServerRuntime.config");
			cayenneRuntime = ServerRuntime.builder().disableModulesAutoLoading().addConfig(serverRuntimeConfig)
					.dataSource(DataSourceBuilder.url(dbUrl).driver(com.mysql.cj.jdbc.Driver.class.getName())
							.userName(username).password(pwd).pool(1, 3).build())
					.build();
		} else {
			dbUrl = config.getString("database.dburl.test");
			String serverRuntimeConfig = config.getString("ServerRuntime.config.test");
			cayenneRuntime = ServerRuntime.builder().disableModulesAutoLoading().addConfig(serverRuntimeConfig)
					.dataSource(DataSourceBuilder.url(dbUrl).driver(com.mysql.cj.jdbc.Driver.class.getName())
							.userName(username).password(pwd).pool(1, 3).build())
					.build();
		}
	}
	
	public  DatabaseConnector getConnector(Configuration config) {
		DatabaseConnector.config=config;
		setDatabase();
		return INSTANCE;
	}

	public static  DatabaseConnector getInstance() {
		return INSTANCE;
	}

	public ServerRuntime getCayenneRuntime() {
		return cayenneRuntime;
	}
}
