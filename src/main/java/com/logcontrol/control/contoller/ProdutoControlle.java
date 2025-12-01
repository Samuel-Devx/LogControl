package com.logcontrol.control.contoller;

import com.logcontrol.control.model.Produto;
import com.logcontrol.control.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.logcontrol.control.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Controller
public class ProdutoControlle {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/cadastrar-produto")
    public String cadastrar(String nome, Double preco, Integer quantidade, String sku, Model model){
        String erro = produtoService.salvar(nome, preco, quantidade, sku);

        if (erro != null) {
            model.addAttribute("erro", erro);
            return "cadastro";
        }
        model.addAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "cadastro";
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/produto/form")
    public String abrirFormulario() {
        return "cadastro";
    }

    @GetMapping("/consulta")
    public String abriConsulta(Model model){
        List<Produto> listaDeProdtos = produtoRepository.findAll();
        model.addAttribute("produtos", listaDeProdtos);
        return "consulta";
    };
    @GetMapping("/abrirPesquisa")
    public String pesqisa (){
        return "buscaSKU";
    }
    @GetMapping("/buscaSku")
    public String pesquisaSku(@RequestParam(value = "sku") String sku, Model model){

        Optional<Produto> produtoPesquisa = produtoRepository.findBysku(sku);

        if(produtoPesquisa.isPresent()){
            model.addAttribute("produtoPesquisa", produtoPesquisa.get());
        }
        else {
            model.addAttribute("mensagemBusca", "Produto com SKU '" + sku + "' não encontrado.");
        }

        return "pesquisa";
    }
    @GetMapping("/deletarProduto")
    public String abriDelete(){
        return "deletarForm";
    }
    @PostMapping("/deletarSku")
    public String deletarProduto(@RequestParam(value = "sku") String sku, Model model){

        Optional<Produto> produtoPesquisa = produtoRepository.findBysku(sku);

        if(produtoPesquisa.isPresent()){
            Produto produto = produtoPesquisa.get();
            produtoRepository.delete(produto);

            model.addAttribute("skuDeletado", sku);
            model.addAttribute("sucesso", true);
            model.addAttribute("mensagem", "Produto com SKU '" + sku + "' foi deletado com sucesso!");
        }
        else{
            model.addAttribute("skuDeletado", sku);
            model.addAttribute("sucesso", false);
            model.addAttribute("mensagem", "Erro: Produto com SKU '" + sku + "' não foi encontrado para deleção.");
        }
        return "resultadoDelete";
    }
}
