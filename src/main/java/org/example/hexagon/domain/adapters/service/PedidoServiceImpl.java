package org.example.hexagon.domain.adapters.service;

import org.example.hexagon.domain.Produto;
import org.example.hexagon.domain.dtos.EstoqueDto;
import org.example.hexagon.domain.dtos.ProdutoDto;
import org.example.hexagon.domain.portas.interfaces.ProdutoServicePort;
import org.example.hexagon.domain.portas.repositories.ProdutoRepositoryPort;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PedidoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public PedidoServiceImpl(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDto produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public List<ProdutoDto> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDto estoqueDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new ChangeSetPersister.NotFoundException();

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }
}