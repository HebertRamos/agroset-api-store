package br.com.app.agrosetapi.produtovenda.entity.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Hramos
 */
@Embeddable
public class CategoriaProdutoPk implements Serializable{

    @Column(name = "CT_ID")
    private Long categoriaId;

    @Column(name = "PVD_ID")
    private Long produtoVendaId;

    public CategoriaProdutoPk() {
    }

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
}
