package br.com.app.agrosetapi.venda.repository;

import br.com.app.agrosetapi.venda.entity.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hramos
 */
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
