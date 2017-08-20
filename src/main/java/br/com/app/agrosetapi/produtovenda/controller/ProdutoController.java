package br.com.app.agrosetapi.produtovenda.controller;

import br.com.app.agrosetapi.produtovenda.entity.ProdutoVenda;
import br.com.app.agrosetapi.produtovenda.repository.ProdutoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/public/agrosetStoreApi/produtos")
public class ProdutoController {

    @Autowired
    ProdutoVendaRepository produtoVendaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProdutoVenda> buscarProdutosPorCategoria(){
        return produtoVendaRepository.buscarTodos();
    }
}
