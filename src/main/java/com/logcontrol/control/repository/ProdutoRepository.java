package com.logcontrol.control.repository;

import com.logcontrol.control.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


    Optional<Produto> findBysku(String sku);

}
