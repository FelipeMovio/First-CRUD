package com.felipemovio.CRUD.business.service;


import com.felipemovio.CRUD.infrastructure.entity.Usuario;
import com.felipemovio.CRUD.infrastructure.repository.UsuarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);

    }

    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow( // tratamento caso o email nao seja encontrado
                () -> new RuntimeException("email nao encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizandoUsuarioPorId(Integer id, Usuario usuario){
         Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                 new RuntimeException("Usuario nao encontrado"));
         Usuario usuarioAtualizado = usuario.builder()
                 .email(usuario.getEmail() != null ? usuario.getEmail() :
                         usuarioEntity.getEmail())
                 .nome(usuario.getNome() != null ? usuario.getNome() :
                         usuarioEntity.getNome())
                 .id(usuarioEntity.getId())
                 .builde()
    }



}
