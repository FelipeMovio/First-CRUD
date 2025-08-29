package com.felipemovio.CRUD.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Table(name = "usuario") // Indica que é uma tabela
@Entity // Indica que é uma entidade
public class Usuario {

    @Id // informando que é um Id
    @GeneratedValue(strategy = GenerationType.AUTO) // fazendo o Id ser gerado automaticamente
    private Integer id;

    @Column(name = "email", unique = true) // nome da coluna e dizendo que o email tem q ser unico
    private String email;

    @Column(name = "nome")
    private String nome;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
