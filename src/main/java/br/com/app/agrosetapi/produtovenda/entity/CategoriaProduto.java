package br.com.app.agrosetapi.produtovenda.entity;

import br.com.app.agrosetapi.produtovenda.entity.pk.CategoriaProdutoPk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_CATEGORIA_PRODUTO", schema = "public")
@IdClass(CategoriaProdutoPk.class)
public class CategoriaProduto {

    @Id
    @Column(name = "CT_ID")
    private Long categoriaId;

    @Id
    @Column(name = "PVD_ID")
    private Long produtoVendaId;

    @ManyToOne
    @JoinColumn(name = "CT_ID", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "PVD_ID", insertable = false, updatable = false)
    private ProdutoVenda produtoVenda;

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getProdutoVendaId() {
        return produtoVendaId;
    }

    public void setProdutoVendaId(Long produtoVendaId) {
        this.produtoVendaId = produtoVendaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProdutoVenda getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(ProdutoVenda produtoVenda) {
        this.produtoVenda = produtoVenda;
    }
}
