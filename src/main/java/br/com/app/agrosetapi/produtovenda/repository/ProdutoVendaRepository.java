package br.com.app.agrosetapi.produtovenda.repository;

import br.com.app.agrosetapi.produtovenda.entity.ProdutoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Hramos
 */
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {

    @Query("SELECT pvd FROM ProdutoVenda pvd JOIN FETCH pvd.itemCompra WHERE pvd.id IN (SELECT pvds.id FROM CategoriaProduto cp JOIN cp.produtoVenda pvds JOIN cp.categoria cat WHERE cat.id = :idCategoria) ")
    public List<ProdutoVenda> findByCategoria(@Param("idCategoria") Long idCategoria);

    @Query("SELECT pvd FROM ProdutoVenda pvd JOIN FETCH pvd.itemCompra ")
    public List<ProdutoVenda> buscarTodos();

}
