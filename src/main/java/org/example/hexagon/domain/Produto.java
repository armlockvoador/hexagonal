package org.example.hexagon.domain;

import org.example.hexagon.domain.dtos.ProdutoDto;

import java.util.UUID;

public class Produto {

    private UUID codigo;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public Produto() {
    }

    public Produto(UUID codigo, String sku, String nome, Double quantidade, Double preco) {
        this.codigo = codigo;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Produto(ProdutoDto produtoDTO) {
        this.sku = produtoDTO.getSku();
        this.nome = produtoDTO.getNome();
        this.preco = produtoDTO.getPreco();
        this.quantidade = produtoDTO.getQuantidade();
    }

    public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoDto toProdutoDTO() {
        return new ProdutoDto(this.sku, this.nome, this.preco, this.quantidade);
    }
}