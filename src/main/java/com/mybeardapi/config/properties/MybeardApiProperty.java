package com.mybeardapi.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mybeard")
public class MybeardApiProperty {

	private String originPermitida = "";

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public static class Seguranca {

		private boolean enableHttps;
		
		private int accessTokenValiditySeconds;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

		public int getAccessTokenValiditySeconds() {
			return accessTokenValiditySeconds;
		}

		public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
			this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		}

}
	
}
