package com.example.officialecomarketspa.controller;

import com.example.officialecomarketspa.model.Usuario;
import com.example.officialecomarketspa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(userService.obtenerTodosLosUsuarios());
    }

    @PostMapping()
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(userService.guardarUsuario(usuario));
    }
}
