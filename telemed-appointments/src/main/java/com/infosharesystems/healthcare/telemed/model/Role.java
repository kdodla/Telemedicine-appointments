package com.infosharesystems.healthcare.telemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infosharesystems.healthcare.telemed.common.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper=false)@ToString
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	
	

}
