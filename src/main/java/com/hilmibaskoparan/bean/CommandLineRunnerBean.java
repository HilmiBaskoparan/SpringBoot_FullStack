package com.hilmibaskoparan.bean;

import com.hilmibaskoparan.business.dto.BlogDto;
import com.hilmibaskoparan.business.service.impl.BlogGenericsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class CommandLineRunnerBean {

    private final BlogGenericsServiceImpl blogGenericsService;

    @Bean
    public CommandLineRunner commandLineRunnerMethod(){
        return args -> {
            List<BlogDto> blogDtoList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                BlogDto blogDto = BlogDto.builder()
                        .header("header " + UUID.randomUUID().toString())
                        .content("content " + UUID.randomUUID().toString())
                        .build();
                blogGenericsService.blogServiceCreate(blogDto);
                blogDtoList.add(blogDto);
            }
        };
    }
}
