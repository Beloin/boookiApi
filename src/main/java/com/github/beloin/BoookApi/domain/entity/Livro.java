package com.github.beloin.BoookApi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @OneToMany
    private List<Comentario> comentarioList;

    @ManyToOne
    private Usuario usuario;

    public void addComentario(Comentario comentario) {
        comentarioList.add(comentario);
    }

}
