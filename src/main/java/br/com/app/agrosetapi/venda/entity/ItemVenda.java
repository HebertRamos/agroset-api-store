package br.com.app.agrosetapi.venda.entity;

import br.com.app.agrosetapi.produtovenda.entity.ProdutoVenda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_ITEM_VENDA", schema = "public")
@SequenceGenerator(name = "SEQ_ITEM_VENDA", sequenceName = "public.SEQ_ITEM_VENDA")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_VENDA")
    @Column(name = "IVD_ID", nullable = false)
    private Long id;

    @Column(name = "IVD_QUANTIDADE")
    private BigDecimal quantidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "VD_ID")
    private Venda venda;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PVD_ID")
    private ProdutoVenda produtoVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ProdutoVenda getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(ProdutoVenda produtoVenda) {
        this.produtoVenda = produtoVenda;
    }
}
