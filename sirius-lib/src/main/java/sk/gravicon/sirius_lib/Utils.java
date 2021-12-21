package sk.gravicon.sirius_lib;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.commons.configuration2.Configuration;

public class Utils {
	private static final Utils INSTANCE = new Utils();
	private final String VERSION = "sirius-lib.Utils version: 0.0.1";
	private Configuration config;
	private String dbUrl;
	private String dbType;

	private Utils() {
		super();

	}
	private ServerRuntime cayenneRuntime;
	/**
	 * @return the cayenneRuntime
	 */
	public ServerRuntime getCayenneRuntime() {
		return cayenneRuntime;
	}



	public static Utils getInstance() {
		return INSTANCE;
	}
	public String getVersion() 
	{ 
		return VERSION;
	}
	public void setDatabase() {
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
	public void setConfig(Configuration config) {
		this.config = config;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public String getDbType() {
		return dbType;
	}
	
	
}
