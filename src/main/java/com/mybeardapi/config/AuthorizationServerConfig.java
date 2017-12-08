package com.mybeardapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.mybeardapi.config.properties.MybeardApiProperty;
import com.mybeardapi.config.token.CustomTokenEnhancer;

@Profile("oauth-security")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MybeardApiProperty mybeardApiProperty;

	/**
	 * JWT - VERIFY SIGNATURE
	 */
	private static final String SECRET = "mybeard23gnomos";
	
	/**
	 * Define credenciais do CLIENT com permissao para obter o token da aplicacao
	 * 
	 * client = angular
	 * grant_type = password
	 * 
	 * Header with Basic Authorization (p.e Basic #secretInBase64#)
	 * Criados escopos para leitura(read) e escrita(write) de acordo com o cliente da aplicacao
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("angular").secret("angular").scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(mybeardApiProperty.getSeguranca().getAccessTokenValiditySeconds())
				.refreshTokenValiditySeconds(1770);
	}

	/**
	 * RefreshToken: Garantindo que enquanto o usuario estiver utilizando a
	 * aplicacao, o acesso nao ira expirar
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));

		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain).reuseRefreshTokens(false)
				.authenticationManager(authenticationManager);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAcessTokenConverter = new JwtAccessTokenConverter();
		jwtAcessTokenConverter.setSigningKey(SECRET);
		return jwtAcessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}

}
