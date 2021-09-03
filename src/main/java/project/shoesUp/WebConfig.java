package project.shoesUp;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.shoesUp.web.filter.LoginCheckFilter;
import project.shoesUp.web.interceptor.LogInterceptor;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //인터셉터 등록할땐 WebMvcConfigurer를 implements 해야한다.

    //스프링부트를 사용할때 필터 등록할때 Bean등록해준다.
    //스프링부트가 WAS띄울때 필터 넣어준다.


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**") //모든 경로 허용
                .excludePathPatterns("/css**", "/*.ico", "/error");//제외경로
    }

    @Bean
    public FilterRegistrationBean loginCheckFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginCheckFilter()); //만들어준 필터를 넣어준다.
        filterFilterRegistrationBean.setOrder(1); //필터 체인순서를 정해준다.
        filterFilterRegistrationBean.addUrlPatterns("/*"); //모든 url에 적용

        return filterFilterRegistrationBean;
    }
}
