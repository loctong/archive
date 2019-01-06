package com.archive.susu.config;

import com.archive.susu.constant.CommonConstant;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class Messages {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(CommonConstant.CHARSET_UTF8);
        messageSource.setBasenames("classpath:i18n/messages",
                "classpath:i18n/app" ,
                "classpath:i18n/validation");
        messageSource.setCacheSeconds(36000);
        return messageSource;
    }

    //https://www.baeldung.com/spring-boot-internationalization
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.JAPANESE);
        Locale localeVN = new Locale("vn","VN");
        slr.setDefaultLocale(localeVN);
        return slr;
    }
}
