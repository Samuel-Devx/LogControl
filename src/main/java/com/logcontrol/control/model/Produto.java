package com.logcontrol.control.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Produtos")
@Data
@NoArgsConstructor
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false, unique = true,length = 50)
    private String sku;

    public Produto(String nome, Double preco, Integer quantidade, String sku) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.sku = sku;
    }
    public String validar() {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome é obrigatório";
        }
        if (nome.length() < 3) {
            return "Nome deve ter pelo menos 3 caracteres";
        }
        if (preco == null || preco <= 0) {
            return "Preço inválido";
        }
        if(sku != null && sku.trim().length() < 3){
            return "SKU deve ter pelo menos 3 caracteres";
        }

        if (quantidade == null) {
            return "A quantidade é obrigatória.";
        }

        if (quantidade < 1) {
            return "Quantidade mínima é 1.";
        }
        return null;
    }

}
