package com.logcontrol.control.service;

import com.logcontrol.control.model.Produto;
import com.logcontrol.control.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {


    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    public String salvar (String nome, Double preco, Integer qantidade, String SKU){
        Produto produto = new Produto(nome,preco, qantidade, SKU);
        String erro = produto.validar();

        if(erro != null){
            return erro;
        }

        repository.save(produto);
        return null;
    }









}
