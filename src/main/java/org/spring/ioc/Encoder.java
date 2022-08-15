package org.spring.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Encoder {
    private IEncoder iEncoder;

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    //@Qualifier("base74Encoder") 생성자에 작성해서 주입 가능
    public Encoder( IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
    public String encode(String message) {
            return iEncoder.encode(message);
    }

}