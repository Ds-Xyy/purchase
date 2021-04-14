package com.turing.purchase.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@MapperScan("com.turing.purchase.mapper")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/common").setViewName("common");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/regist").setViewName("regist");
        registry.addViewController("/left").setViewName("leftRequire");
        registry.addViewController("/bar").setViewName("bar");
        registry.addViewController("/jiffprov_look").setViewName("supplyman/jiffprov_look");


    }
//    配置视图解析器---JSP
//    	@Bean
//	public ViewResolver viewResolver(){
//		//创建一个视图解析器
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		//设置前后缀
//		resolver.setPrefix("/WEB-INF/");
//		resolver.setSuffix(".js");
//		//返回视图解析器
//		return resolver;
//	}

    //配置模板解析器
//    @Bean
//    public ITemplateResolver templateResolver(ApplicationContext ctx){
//        //创建一个模板解析器对象
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        //设置上下文
//        templateResolver.setApplicationContext(ctx);
//        //设置前缀
//        //templateResolver.setPrefix("/");
//        //设置后缀
//        //templateResolver.setSuffix(".html");
//        //设置模板
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        //设置是否开启缓存---开发阶段（禁用缓存）
//        templateResolver.setCacheable(false);
//        //设置编码
//        templateResolver.setCharacterEncoding("utf-8");
//        //返回
//        return templateResolver;
//    }
}
