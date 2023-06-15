package com.hilmibaskoparan.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
abstract public class AuditingAwareBaseDto implements Serializable {

    // Auditing: Database hangi kullanıcı ne zaman ne ekledi veya ne güncelledi vs.

    // Serialization
    public static final Long serialVersionUID = 1L;

    // ID
    private Long id;

    // DATE
    private Date systemDate;

    @JsonIgnore // Backend'de giden veriyi saklar
    protected String createdUser;

    @JsonIgnore
    protected Date createdDate;

    @JsonIgnore
    protected String updatedUser;

    @JsonIgnore
    protected Date updatedDate;
}
