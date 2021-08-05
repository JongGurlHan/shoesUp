package project.shoesUp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.shoesUp.interceptor.TopMenuInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private TopMenuInterceptor topMenuInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(topMenuInterceptor)
                .addPathPatterns("/**");
    }
}
