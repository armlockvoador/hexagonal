package org.example.hexagon.domain.portas.repositories;


import org.example.hexagon.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();

    Produto buscarPeloSku(String sku);

    void salvar(Produto produto);
}