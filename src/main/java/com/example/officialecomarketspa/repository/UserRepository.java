package com.example.officialecomarketspa.repository;

import com.example.officialecomarketspa.model.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Integer> {
}
