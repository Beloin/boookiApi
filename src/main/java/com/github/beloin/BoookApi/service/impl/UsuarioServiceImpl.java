package com.github.beloin.BoookApi.service.impl;

import com.github.beloin.BoookApi.domain.entity.Usuario;
import com.github.beloin.BoookApi.domain.repository.UsuarioRepository;
import com.github.beloin.BoookApi.exception.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public UserDetails autenticar(Usuario usuario) {
        UserDetails userDetails = loadUserByUsername(usuario.getLogin());
        boolean passwordMatches = passwordEncoder.matches(usuario.getSenha(), userDetails.getPassword());
        if (passwordMatches) return userDetails;
        throw new SenhaInvalidaException();
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .build();
    }
}
