package com.infosharesystems.healthcare.telemed.dto;

import lombok.ToString;

@ToString
public class ProviderDTO {

	private Long providerId;

	private String providerName;

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

}
