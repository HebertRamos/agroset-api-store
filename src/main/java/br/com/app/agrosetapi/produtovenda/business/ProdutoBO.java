package br.com.app.agrosetapi.produtovenda.business;

import br.com.app.agrosetapi.produtovenda.entity.ProdutoVenda;
import br.com.app.agrosetapi.produtovenda.repository.ProdutoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hramos
 */
@Component
public class ProdutoBO {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;


    public List<ProdutoVenda> buscarProdutosPorCategoria(Long idCategoria){
        return produtoVendaRepository.findByCategoria(idCategoria);
    }
}
