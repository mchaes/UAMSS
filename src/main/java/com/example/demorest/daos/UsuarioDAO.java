package com.example.demorest.daos;

import org.springframework.data.repository.CrudRepository;

import com.example.demorest.entidades.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

    
}