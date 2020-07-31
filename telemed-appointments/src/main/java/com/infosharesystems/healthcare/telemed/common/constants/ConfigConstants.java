/**
 *
 */

package com.infosharesystems.healthcare.telemed.common.constants;

/**
 * The Constants for Configuration.
 */
public interface ConfigConstants {

	String DEV_PROFILE = "dev";
	String PROD_PROFILE = "production";
	/** The Constant DEFAULT_ENCODING. */
	String DEFAULT_ENCODING = "UTF-8";
	String MESSAGES_BASENAME = "messages";
	/** The Constant LRU. */
	String LRU = "LRU";
	String[] OAUTH_GRANT_TYPES = { "password", "refresh_token" };
	String[] OAUTH_SCOPES = { "trust" };
	String TELEMEDICINE_API = "/restapi";
	String AUTHORITY_PUBLIC = "ROLE_PUBLIC";
	String AUTHORITY_LOGGED_IN_USER = "ROLE_LOGGED_IN";
	String USER_DATA_SESSION_KEY = "user-data";
}
