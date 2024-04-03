package api.mykeycloak.security;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String ROLE = "ROLE_";
    private static final String CLAIM = "realm_access";

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Map<String, List<String>> realmAccess = jwt.getClaim(CLAIM);
        return new JwtAuthenticationToken(jwt, grants(realmAccess.get("roles").stream().toList()));
    }

    private List<SimpleGrantedAuthority> grants(List<String> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(ROLE.concat(r)))
                .collect(Collectors.toList());
    }
}
