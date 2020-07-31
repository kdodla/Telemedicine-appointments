
package com.infosharesystems.healthcare.telemed.dto.response;

import java.util.List;

import com.infosharesystems.healthcare.telemed.common.response.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data@EqualsAndHashCode(callSuper=true)@ToString
public class GetResponse extends BaseResponse {

	private static final long serialVersionUID = 1729761631118443455L;
	private List<?> response;
}
