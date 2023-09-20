package com.deyvidsalvatore.produtosapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyvidsalvatore.produtosapi.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID>{

}

