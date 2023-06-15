package com.hilmibaskoparan.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
abstract public class AuditingAwareBaseDto implements Serializable {

    // Auditing: Database hangi kullanıcı ne zaman ne ekledi veya ne güncelledi vs.

    // Serialization
    public static final Long serialVersionUID = 1L;

    private Long id;            // ID
    @Builder.Default
    private Date systemDate = new Date(System.currentTimeMillis());    // DATE

    // AUDITING
    @JsonIgnore // Backend'de giden veriyi saklar
    protected String createdUser;

    @JsonIgnore
    protected Date createdDate;

    @JsonIgnore
    protected String updatedUser;

    @JsonIgnore
    protected Date updatedDate;
}
