package com.inkombizz.web.repository;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inkombizz.web.util.StatusEnum;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author de4ragil
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRepository implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;
    
	private String code;
    private String username;
    private String password;
    private String email;

    private StatusEnum activeStatus;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;


}
