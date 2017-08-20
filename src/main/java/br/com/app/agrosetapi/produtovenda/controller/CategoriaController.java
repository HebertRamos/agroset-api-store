package br.com.app.agrosetapi.produtovenda.controller;

import br.com.app.agrosetapi.produtovenda.business.CategoriaBO;
import br.com.app.agrosetapi.produtovenda.business.ProdutoBO;
import br.com.app.agrosetapi.produtovenda.entity.Categoria;
import br.com.app.agrosetapi.produtovenda.entity.ProdutoVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/public/agrosetStoreApi/categorias")
public class CategoriaController {

    @Autowired
    CategoriaBO categoriaBO;

    @Autowired
    ProdutoBO produtoBO;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> bucarTodas(){
        return categoriaBO.buscarTodasAsCategoriasPaiEFilhos();
    }

    @RequestMapping(path = "/{id}/produtos", method = RequestMethod.GET)
    public List<ProdutoVenda> buscarProdutosPorCategoria(@PathVariable("id") Long idCategoria){
        return produtoBO.buscarProdutosPorCategoria(idCategoria);
    }
}
