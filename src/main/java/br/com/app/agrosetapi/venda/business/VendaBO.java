package br.com.app.agrosetapi.venda.business;

import br.com.app.agrosetapi.seguranca.entity.Usuario;
import br.com.app.agrosetapi.venda.entity.ItemVenda;
import br.com.app.agrosetapi.venda.entity.SaidaItem;
import br.com.app.agrosetapi.venda.entity.Venda;
import br.com.app.agrosetapi.venda.enumeration.StatusVendaEnum;
import br.com.app.agrosetapi.venda.enumeration.TipoSaidaItemEnum;
import br.com.app.agrosetapi.venda.enumeration.TipoVendaEnum;
import br.com.app.agrosetapi.venda.repository.ItemVendaRepository;
import br.com.app.agrosetapi.venda.repository.SaidaItemRepository;
import br.com.app.agrosetapi.venda.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Hramos
 */

@Component
public class VendaBO {


    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ItemVendaRepository itemVendaRepository;

    @Autowired
    SaidaItemRepository saidaItemRepository;

    @Transactional
    public Venda criarVendaComSaida(List<ItemVenda> itens, Usuario usuario){

        Venda venda = instanciarNovaVenda(usuario, TipoVendaEnum.COMPRA);
        salvarItensVenda(itens, venda);
        criarSaidaEstoqueItens(itens, usuario);

        return atualizarStatusVenda(venda, StatusVendaEnum.CONCLUIDO);
    }

    @Transactional
    public Venda criarVendaReserva(List<ItemVenda> itens, Usuario usuario){

        Venda venda = instanciarNovaVenda(usuario, TipoVendaEnum.RESERVA);
        salvarItensVenda(itens, venda);

        return atualizarStatusVenda(venda, StatusVendaEnum.CONCLUIDO);
    }

    private Venda atualizarStatusVenda(Venda venda, StatusVendaEnum status){
        venda.setStatus(status);
        return vendaRepository.save(venda);
    }

    private void criarSaidaEstoqueItens(List<ItemVenda> itens, Usuario usuario){

        itens.forEach(itemVenda -> {
            criarNovaSaidaItem(itemVenda, usuario);
        });
    }

    private void criarNovaSaidaItem(ItemVenda itemVenda, Usuario usuario) {


        SaidaItem saidaItem = new SaidaItem();
        saidaItem.setData(new Date());
        saidaItem.setItemCompra(itemVenda.getProdutoVenda().getItemCompra());
        saidaItem.setQuantidade(itemVenda.getQuantidade());
        saidaItem.setTipo(TipoSaidaItemEnum.AUTOMATICA);
        saidaItem.setUsuario(usuario);

        saidaItemRepository.save(saidaItem);
    }

    private void salvarItensVenda(List<ItemVenda> itens, Venda venda){

        itens.forEach(itemVenda -> {
            itemVenda.setVenda(venda);
            itemVendaRepository.save(itemVenda);
        });
    }

    private Venda instanciarNovaVenda(Usuario usuario, TipoVendaEnum tipo){

        Venda venda = new Venda();
        venda.setData(new Date());
        venda.setStatus(StatusVendaEnum.PENDENTE);
        venda.setTipo(tipo);
        venda.setUsuario(usuario);

        return vendaRepository.save(venda);
    }
}
