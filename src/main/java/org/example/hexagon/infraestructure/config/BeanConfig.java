package org.example.hexagon.infraestructure.config;

import org.example.hexagon.domain.adapters.service.PedidoServiceImpl;
import org.example.hexagon.domain.portas.interfaces.ProdutoServicePort;
import org.example.hexagon.domain.portas.repositories.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImpl(produtoRepositoryPort);
    }
}