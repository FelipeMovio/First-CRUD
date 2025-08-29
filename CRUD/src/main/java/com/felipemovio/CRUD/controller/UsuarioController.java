package com.felipemovio.CRUD.controller;


import com.felipemovio.CRUD.business.service.UsuarioService;
import com.felipemovio.CRUD.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    @Autowired
    private final UsuarioService usuarioService;

   @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody Usuario usuario){
        usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
       List<Usuario> usuarios = usuarioService.buscarTodosUsuarios();
       return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizandoUsuarioPorId(@PathVariable Integer id,
                                                        @RequestBody Usuario usuario) {
        try {
            usuarioService.atualizandoUsuarioPorId(id, usuario);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


}
