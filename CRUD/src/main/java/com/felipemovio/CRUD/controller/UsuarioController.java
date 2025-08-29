package com.felipemovio.CRUD.controller;


import com.felipemovio.CRUD.business.service.UsuarioService;
import com.felipemovio.CRUD.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    @Autowired
    private final UsuarioService usuarioService;

    @RequestMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody Usuario usuario){
        usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail( @RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizandoUsuarioPorId(@RequestParam Integer id,
                                                        @RequestBody Usuario usuario){

        usuarioService.atualizandoUsuarioPorId(id,usuario);
        return ResponseEntity.ok().build();
    }

}
