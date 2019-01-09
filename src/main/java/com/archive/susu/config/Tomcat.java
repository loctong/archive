package com.archive.susu.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: muon deploy on server Tomcat
 * Ref: https://o7planning.org/vi/11903/trien-khai-ung-dung-spring-boot-tren-tomcat-server
 */
@Configuration
public class Tomcat extends SpringBootServletInitializer {

	@Value("${server.http.port}")
	private int httpPort;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.https.enable}")
	private boolean httpsEnable;

	private static Class<Tomcat> applicationClass = Tomcat.class;

    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
			((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
			}
		};
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
	}

	private Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(httpPort);
		connector.setSecure(false);
		if(httpsEnable) {
			// Always redirect to HTTPS
			connector.setRedirectPort(port);
		}
		return connector;
	}

}
