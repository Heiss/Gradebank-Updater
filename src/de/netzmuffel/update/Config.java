package de.netzmuffel.update;

public final class Config {
	static final String DOMAIN = "http://gradebank.netzmuffel.de/";
	static final String PATH = "";
	static final String XMLFILE = "version.properties";
	static final String FILE = "GradeBank.jar";
	
	static final String INSTALLFILE = "./GradeBank.jar";
	static final String INSTALLXML = "./version.properties";
	
	static String UPDATE = DOMAIN + PATH + XMLFILE;
	static String DOWNLOAD = DOMAIN + PATH + FILE;
	
	public Config() {
	}
}
