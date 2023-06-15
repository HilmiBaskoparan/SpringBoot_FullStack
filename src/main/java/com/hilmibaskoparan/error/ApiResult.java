package com.hilmibaskoparan.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@Log4j2
// Backend'deki sadece dolu verileri Frontend'de göstersin (JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    private int status;
    private String error;
    private String path;
    private String message;
    private Date createdDate;
    private Map<String, Object> validationErrors;

    public ApiResult() {}

    public ApiResult(int status, String error, String path, String message) {
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;
    }

    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }
}
