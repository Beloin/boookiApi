package com.github.beloin.BoookApi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150)
    @NotEmpty(message = "Login não pode ser vazio")
    private String login;

    @Column(length = 100)
    @NotEmpty(message = "Senha não pode ser vazia")
    private String senha;

    @Column(length = 100)
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @OneToMany
    List<Livro> livrosList;

    public void addLivro(Livro livro) {
        livrosList.add(livro);
    }

}
