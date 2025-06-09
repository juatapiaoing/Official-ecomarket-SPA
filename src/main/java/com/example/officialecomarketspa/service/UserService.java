package com.example.officialecomarketspa.service;


import com.example.officialecomarketspa.model.Usuario;
import com.example.officialecomarketspa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> obtenerTodosLosUsuarios(){
        return userRepository.findAll();
    }

    public Optional obtenerNombreUsuario(int id){
        return userRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario){
        return userRepository.save(usuario);
    }


}
