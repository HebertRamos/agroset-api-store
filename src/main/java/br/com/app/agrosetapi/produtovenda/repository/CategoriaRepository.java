package br.com.app.agrosetapi.produtovenda.repository;

import br.com.app.agrosetapi.produtovenda.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Hramos
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT ct FROM Categoria ct WHERE ct.pai IS NULL")
    public List<Categoria> buscarCateoriasSemPai();

    @Query("SELECT ct FROM Categoria ct WHERE ct.pai.id = :idPai")
    public List<Categoria> buscarCateoriasFilhas(@Param("idPai") Long idPai );
}
