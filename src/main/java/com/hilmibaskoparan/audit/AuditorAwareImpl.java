package com.hilmibaskoparan.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

// @Component: işaretlediği nesneyi Spring'in bir nesnesi olmasını sağlıyor
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        // Database ile giriş yapmış kullanıcı bilgilerini almak
        // Sistemdeki kullanıcı ismini Session ile almalısın

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            System.out.println(authentication.getName());
            System.out.println(authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }

        // Eğer sistemde birisi varsa o kişinin ismini eklesin yoksa null döndürsün
        // return Optional.ofNullable(authentication != null ? authentication.getName() : null);

        return Optional.of("Hilmi_40");
    }
}
