package com.hilmibaskoparan.error;

import com.hilmibaskoparan.util.FrontEndURL;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor    // for Injection

// for API
// SpringBoot defaulttan gelen error'ı kendimize göre customize yapıyoruz.
@RestController
@CrossOrigin(origins = FrontEndURL.FRONTEND_URL)
public class CustomErrorHandleWebRequest implements ErrorController {

    // Constructor Injection with RequiredArgsConstructor
    private final ErrorAttributes errorAttributes;

    // 1.YOL
    // http://localhost:4040/error
    // Spring'ten gelen /error yakalayıp custom handle yapmak için
    @RequestMapping("/error")
    public ApiResult handleError(WebRequest webRequest) {
        // ApiResult değişkenlerini atamak
        int status;
        String path;
        String message;
        ApiResult apiResult;

        // Spring 2.3>= sonra böyle oldu
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS)
        );

        status = (Integer) attributes.get("status");
        path = (String) attributes.get("path");
        message = (String) attributes.get("message");
        apiResult = new ApiResult(status, path, message);

        // Attributes da apiResult varsa
        if (attributes.containsKey("errors")){
            List<FieldError> fieldErrorList = (List<FieldError>) attributes.get("errors");
            Map<String, Object> validationMistake = new HashMap<>();
            for (FieldError f : fieldErrorList) {
                validationMistake.put(f.getField(), f.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationMistake);
        }

        return apiResult;
    }
}
