package com.felipemovio.CRUD.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario") // Indica que é uma tabela
@Entity // Indica que é uma entidade
public class Usuario {

    @Id // informando que é um Id
    @GeneratedValue(strategy = GenerationType.AUTO) // fazendo o Id ser gerado automaticamente
    private Long id;

    @Column(name = "email", unique = true) // nome da coluna e dizendo que o email tem q ser unico
    private String email;

    @Column(name = "nome")
    private String nome;


    public Usuario(Usuario usuario) {

    }
}
