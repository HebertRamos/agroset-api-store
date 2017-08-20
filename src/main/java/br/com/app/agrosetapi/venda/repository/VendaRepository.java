package br.com.app.agrosetapi.venda.repository;

import br.com.app.agrosetapi.venda.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hramos
 */
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
