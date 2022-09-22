package org.example.hexagon.adapters.controllers;

import org.example.hexagon.domain.dtos.EstoqueDto;
import org.example.hexagon.domain.dtos.ProdutoDto;
import org.example.hexagon.domain.portas.interfaces.ProdutoServicePort;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProductController {

    private final ProdutoServicePort produtoServicePort;

    public ProductController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void criarProdutos(@RequestBody ProdutoDto produtoDTO) {
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDto> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDto estoqueDTO) throws ChangeSetPersister.NotFoundException {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }
}