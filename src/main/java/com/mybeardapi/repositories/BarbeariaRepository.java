package com.mybeardapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybeardapi.model.Barbearia;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {

}
