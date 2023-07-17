//package com.trofimovlipatnikov.medicalcalculator.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring6.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//@Configuration
//@EnableWebMvc
//public class ThymeleafConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.addDialect(springSecurityDialect());
//        return templateEngine;
//    }
//
//    private ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setTemplateMode("HTML");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//
//    @Bean
//    public ViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//        return viewResolver;
//    }
//
//
//    @Bean
//    public SpringSecurityDialect springSecurityDialect() {
//        return new SpringSecurityDialect();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }
//}
