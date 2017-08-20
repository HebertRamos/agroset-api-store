package br.com.app.agrosetapi.venda.controller;

import br.com.app.agrosetapi.seguranca.helper.LoggedUer;
import br.com.app.agrosetapi.venda.business.VendaBO;
import br.com.app.agrosetapi.venda.entity.ItemVenda;
import br.com.app.agrosetapi.venda.entity.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/agrosetStoreApi/vendas")
public class VendaController {

    @Autowired
    LoggedUer loggedUer;

    @Autowired
    VendaBO vendaBO;

    @RequestMapping(path = "/compra", method = RequestMethod.POST)
    public Venda criarVendaComSaida(@RequestBody List<ItemVenda> itens){
        return vendaBO.criarVendaComSaida(itens, loggedUer.getUsuarioLogado());
    }

    @RequestMapping(path = "/reserva", method = RequestMethod.POST)
    public Venda criarVendaReserva(@RequestBody List<ItemVenda> itens){
        return vendaBO.criarVendaReserva(itens, loggedUer.getUsuarioLogado());
    }
}
