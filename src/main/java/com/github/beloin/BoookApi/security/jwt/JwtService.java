package com.github.beloin.BoookApi.security.jwt;

import com.github.beloin.BoookApi.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;
    @Value("${security.jwt.chave-assinatura}")
    private String key;

/*    public String gerarToken(Usuario usuario) {
        long expirationLong = Long.valueOf()
    }*/
}
