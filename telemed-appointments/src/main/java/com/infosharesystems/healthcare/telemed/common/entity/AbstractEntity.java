package com.infosharesystems.healthcare.telemed.common.entity;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity{

	@Column(name = "is_active")
	@Setter @Getter private Boolean isActive = Boolean.TRUE;
	
	@Column(name = "created_by", updatable = false, nullable = false)
	@CreatedBy
	@Setter protected String createdBy = "0";
	
	@Column(name="modified_by", nullable = false)
	@LastModifiedBy
	@Setter @Getter private String modifiedBy = "0";
	
	@Column(name="created_date", updatable = false, nullable = false)
	@CreatedDate
	@Setter @Getter protected Timestamp createdDate;
	
	@Column(name="modified_date", nullable = true)
	@LastModifiedDate
	@Setter private Timestamp modifiedDate;
		
	@PrePersist
    public void touchForCreate() {
        this.setCreatedDate(new Timestamp(new Date().getTime()));
    }

    @PreUpdate
    public void touchForUpdate() {
        setModifiedDate(new Timestamp(new Date().getTime()));
    }
}