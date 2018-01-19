package com.alexandre.desafiocrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.desafiocrud.domain.Usuario; 

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

}
