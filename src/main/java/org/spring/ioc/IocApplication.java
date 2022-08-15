package org.spring.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {
    // 스프링이 실행될 때 Component 어노테이션이 붙은 클래스를 찾아서 직접 객체를 싱글톤형태로 만들어, 스프링 컨테이너에서 관리한다.
    // 스프링 컨테이너에서 관리되는 객체들을 bean이라고 한다.
    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("base64Encode",Encoder.class);
        String url ="www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);

        System.out.println(result);
    }
}

@Configuration // 한 클래스에서 여러 bean을 등록할것이다.
class AppConfig {
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new  Encoder(urlEncoder);
    }
}