package br.com.app.agrosetapi.produtovenda.entity;

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
@Table(name = "TB_PRODUTO_VENDA", schema = "public")
@SequenceGenerator(name = "SEQ_PRODUTO_VENDA", sequenceName = "public.SEQ_PRODUTO_VENDA")
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRODUTO_VENDA")
    @Column(name = "PVD_ID", nullable = false)
    private Long id;

    @Column(name = "PVD_PRECO", nullable = false)
    private BigDecimal preco;

    @Column(name = "PVD_FOTO", nullable = false)
    private String foto;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IC_ID")
    private ItemCompra itemCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
}
