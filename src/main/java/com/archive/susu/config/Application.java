package com.archive.susu.config;

import com.archive.susu.constant.CommonConstant;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application extends SpringBootServletInitializer {

	@Value("${server.http.port}")
	private int httpPort;
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.https.enable}")
	private boolean httpsEnable;

	private static Class<Application> applicationClass = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(CommonConstant.CHARSET_UTF8);
        messageSource.setBasenames("classpath:i18n/messages", "classpath:i18n/app" , "classpath:i18n/validation");
        messageSource.setCacheSeconds(36000);
        return messageSource;
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
