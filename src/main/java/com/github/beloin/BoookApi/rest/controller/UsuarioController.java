package com.github.beloin.BoookApi.rest.controller;

import com.github.beloin.BoookApi.domain.entity.Usuario;
import com.github.beloin.BoookApi.domain.repository.UsuarioRepository;
import com.github.beloin.BoookApi.rest.dto.UsuarioDTO;
import com.github.beloin.BoookApi.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO salvar(@RequestBody @Valid Usuario usuario) {
        var encryptedPassword = encoder.encode(usuario.getSenha());
        usuario.setSenha(encryptedPassword);
        Usuario saved = usuarioService.salvar(usuario);
        return new UsuarioDTO(saved.getLogin(), saved.getNome());
    }


}
