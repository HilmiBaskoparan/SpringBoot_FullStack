package com.hilmibaskoparan.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {

    // ModelMapper: Java'da DTO ile Entity arasındaki bir köprüdür.
    // DTO'yu Entity'e Entity'i DTO'ya çevirmek kullanıyoruz.

    /*
    Uygulamalar genellikle benzer ancak farklı nesne modellerinden oluşur;
    burada iki modeldeki veriler benzer olabilir ancak modellerin yapısı ve ilgileri farklıdır.
    Nesne eşleme, bir modeli diğerine dönüştürmeyi kolaylaştırarak ayrı modellerin ayrı kalmasına izin verir.

    ModelMapper'ın amacı, belirli kullanım durumlarını ele almak için basit,
    yeniden düzenleme açısından güvenli bir API sağlarken, aynı bir insanın yaptığı gibi,
    bir nesne modelinin diğerine nasıl eşleştiğini otomatik olarak belirleyerek, nesne eşlemeyi kolaylaştırmaktır.
    */

    @Bean
    public ModelMapper modelMapperMethod() {
        return new ModelMapper();
    }

}
