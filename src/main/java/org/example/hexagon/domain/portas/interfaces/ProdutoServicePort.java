package org.example.hexagon.domain.portas.interfaces;

import org.example.hexagon.domain.dtos.EstoqueDto;
import org.example.hexagon.domain.dtos.ProdutoDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDto> buscarProdutos();

    void criarProduto(ProdutoDto produtoDTO);

    void atualizarEstoque(String sku, EstoqueDto estoqueDTO) throws ChangeSetPersister.NotFoundException;
}