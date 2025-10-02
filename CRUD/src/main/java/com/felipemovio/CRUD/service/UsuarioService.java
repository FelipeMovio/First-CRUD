package com.felipemovio.CRUD.service;


import com.felipemovio.CRUD.infrastructure.entity.Usuario;
import com.felipemovio.CRUD.infrastructure.repository.UsuarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository repository;


    public void criarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);

    }

    public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> users = repository.findAll();
        return users.stream().map(Usuario::new).toList();
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void deletarUsuarioPorID(Integer id){
        Usuario usuario = repository.findById(id).get();
        repository.delete(usuario);
    }

    public void atualizandoUsuarioPorId(Integer id, Usuario usuario){
         Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                 new RuntimeException("Usuario nao encontrado"));
         Usuario usuarioAtualizado = Usuario.builder()
                 .email(usuario.getEmail() != null ? usuario.getEmail() :
                         usuarioEntity.getEmail())
                 .nome(usuario.getNome() != null ? usuario.getNome() :
                         usuarioEntity.getNome())
                 .id(usuarioEntity.getId())
                 .build();
         repository.saveAndFlush(usuarioAtualizado);
    }



}
