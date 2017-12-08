package com.mybeardapi.test.oauth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import com.mybeardapi.model.Permissao;
import com.mybeardapi.model.Usuario;
import com.mybeardapi.security.UsuarioSistema;

@Component
public class OAuthHelper {
 
    @Autowired
    AuthorizationServerTokenServices tokenservice;
 
    public RequestPostProcessor addBearerToken(final String username, final String email, String... authorities) {
        return mockRequest -> {
        	Usuario usuario = new Usuario();
        	usuario.setNome(username);
        	usuario.setEmail(email);
        	usuario.setSenha("test");
        	
        	List<Permissao> permissoes = new ArrayList<>();
        	for (String string : authorities) {
        		permissoes.add(new Permissao(string));
			}
        	usuario.setPermissoes(permissoes);
        	
        	Set<SimpleGrantedAuthority> grantAuthorities = new HashSet<>(); 
        	usuario.getPermissoes().forEach(p -> grantAuthorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
            // Create OAuth2 token
            OAuth2Request oauth2Request = new OAuth2Request(null, "angular", null, true, null, null, null, null, null);
            Authentication userauth = new TestingAuthenticationToken(new UsuarioSistema(usuario, grantAuthorities), null, authorities);
            OAuth2Authentication oauth2auth = new OAuth2Authentication(oauth2Request, userauth);
            OAuth2AccessToken token = tokenservice.createAccessToken(oauth2auth);
 
            // Set Authorization header to use Bearer
            mockRequest.addHeader("Authorization", "Bearer " + token.getValue());
            return mockRequest;
        };
    }
}