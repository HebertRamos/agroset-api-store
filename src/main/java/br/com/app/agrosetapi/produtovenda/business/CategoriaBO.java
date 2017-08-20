package br.com.app.agrosetapi.produtovenda.business;

import br.com.app.agrosetapi.produtovenda.entity.Categoria;
import br.com.app.agrosetapi.produtovenda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Hramos
 */
@Component
public class CategoriaBO {


    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> buscarTodasAsCategoriasPaiEFilhos() {

        List<Categoria> categorias = categoriaRepository.buscarCateoriasSemPai();

        preencherArvoreCategorias(categorias);

        return categorias;
    }

    private void preencherArvoreCategorias(List<Categoria> categoriasFilhas){


        for(Categoria categoriaFilha : categoriasFilhas){

            List<Categoria> categoriasNeta = categoriaRepository.buscarCateoriasFilhas(categoriaFilha.getId());

            if(!CollectionUtils.isEmpty(categoriasNeta)){

                categoriaFilha.setFilhas(categoriasNeta);
                preencherArvoreCategorias(categoriasNeta);
            }

        }

    }




}
