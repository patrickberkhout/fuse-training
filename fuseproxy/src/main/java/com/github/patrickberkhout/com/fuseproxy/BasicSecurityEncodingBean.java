package com.github.patrickberkhout.com.fuseproxy;

import java.util.Base64;
import java.util.Map;

import org.apache.camel.Properties;

public class BasicSecurityEncodingBean {
	public String process(@Properties Map<String, Object> props) throws Exception {

		String authorization = props.get("backendUsername") + ":" + props.get("backendPassword");
		byte[] authEncBytes = Base64.getEncoder().encode(authorization.getBytes());
		String authStringEnc = new String(authEncBytes);
		return "Basic " + authStringEnc;

	}

}