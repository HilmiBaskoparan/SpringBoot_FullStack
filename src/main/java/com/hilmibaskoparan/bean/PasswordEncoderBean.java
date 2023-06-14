package com.hilmibaskoparan.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {
    // MASKELEME YAPMAK İÇİN

    /*
    PasswordEncoder: parolaların tek yönlü olarak şifrelenerek güvenli bir şekilde saklanmasını ve daha sonra doğrulanmasını sağlar.
    Bu şifreleme tek yönlü olduğu için encode edilen değerden parolaya erişilemez.
    Methods: encode(), matches(), upgradeEncoding() */

    @Bean
    public PasswordEncoder passwordEncoderMethod() {
        return new BCryptPasswordEncoder();
    }
}
