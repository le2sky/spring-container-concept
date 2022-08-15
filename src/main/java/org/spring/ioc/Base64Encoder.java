package org.spring.ioc;


import org.springframework.stereotype.Component;

import java.util.Base64;

// 프레임워크에 의해 Bean으로 등록된다.
@Component("base74Encoder")
public class Base64Encoder implements IEncoder {
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}