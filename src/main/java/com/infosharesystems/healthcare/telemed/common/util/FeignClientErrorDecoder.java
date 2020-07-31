
package com.infosharesystems.healthcare.telemed.common.util;

import com.infosharesystems.healthcare.telemed.common.exception.FeignClientException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

	private ErrorDecoder delegate = new ErrorDecoder.Default();
	
	@Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
        	return new FeignClientException(
                    response.status(),
                    response.reason()
            );
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new FeignClientException(
                    response.status(),
                    response.reason()
            );
        }
        return delegate.decode(methodKey, response);
    }
}