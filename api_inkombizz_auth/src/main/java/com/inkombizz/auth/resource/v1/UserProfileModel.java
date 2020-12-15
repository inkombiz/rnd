package com.inkombizz.auth.resource.v1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "scr_user")
public class UserProfileModel {
    
    @Id
    @Column(name = "Code")
    private String code;
    
    @JsonIgnore
    @Column(name = "FirstName", updatable = false)
    private String firstName;

    @JsonIgnore
    @Column(name = "LastName", updatable = false)
    private String fLastName;
    
    @Min(18)
    @Digits(fraction = 0, integer = 2, message = "Harus Berisikan Nomor")
    @Column(name = "Age")
    private int age = 18;
    
    @Past(message = "Tanggal Tidak boleh Lebih besar dari tanggal sekarang")
    @Column(name = "BirthDate")
    private Date birthDate;
    
    @Future(message = "Tanggal Tidak boleh Lebih kecil dari tanggal sekarang")
    @Column(name = "PassDate")
    private Date passDate;
    
    @NotBlank
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
