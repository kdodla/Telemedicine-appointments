
package com.infosharesystems.healthcare.telemed.common.session;
	
import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionContext {

	@Autowired
	private HttpSession session;

	public Object getAttribute(String name) {
		return session.getAttribute(name);
	}

	public String getSessionId() {
		return session.getId();
	}

	public void invalidate() {
		session.invalidate();
	}

	public void setAttribute(String name, Serializable value) {
		session.setAttribute(name, value);
	}
}