package com.example.demorest.daos;

import org.springframework.data.repository.CrudRepository;
import com.example.demorest.entidades.Compra;

public interface CompraDAO extends CrudRepository<Compra,Integer>{
    
}
