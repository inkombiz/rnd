package com.inkombizz.auth.resource.v1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inkombizz.auth.common.StatusEnum;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author de4ragil
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "scr_role")
public class RoleModel {
    
    @Id
    @Column(name = "Code")
    private String code;
    
    @NotBlank
    @Column(name = "Name")
    private String name;
    
//    @NotNull
    @Column(name = "ActiveStatus")
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum activeStatus;

    @JsonIgnore
    @Column(name = "CreatedBy", updatable = false)
    private String createdBy;

    @JsonIgnore
    @Column(name = "CreatedDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @JsonIgnore
    @Column(name = "UpdatedBy")
    private String updatedBy;

    @JsonIgnore
    @Column(name = "UpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;


}
