package com.ragku.restful.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
@ComponentScan("com.ragku.restful")
@EnableWebMvc
//@PropertySource({"classpath:site-jdbc.properties"})
public class SpringConfig {
    
    @Autowired private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;
    @Autowired private List<HttpMessageConverter<?>> messageConverters;
    
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
    @Bean(name = "fastJsonHttpMessageConverter")
    public FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> tps = new ArrayList<MediaType>();
        tps.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(tps);
        return converter;
    }
    
    @Bean(name = "messageConverters")
    public List<HttpMessageConverter<?>> getHttpMessageConverters() {
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(fastJsonHttpMessageConverter);
        return list;
    }

    /**
     * requestMappingHandlerAdapter 必须指定bean name 才会被spring认识！
     */
    @Bean(name = "requestMappingHandlerAdapter")
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new  RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(messageConverters);
        return requestMappingHandlerAdapter;
    }
}
