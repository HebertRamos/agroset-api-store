package br.com.app.agrosetapi.venda.entity;

import br.com.app.agrosetapi.produtovenda.enumeration.AtivoInativoEnum;
import br.com.app.agrosetapi.seguranca.entity.Usuario;
import br.com.app.agrosetapi.venda.enumeration.StatusVendaEnum;
import br.com.app.agrosetapi.venda.enumeration.TipoVendaEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_VENDA", schema = "public")
@SequenceGenerator(name = "SEQ_VENDA", sequenceName = "public.SEQ_VENDA")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_VENDA")
    @Column(name = "VD_ID", nullable = false)
    private Long id;

    @Column(name = "VD_DATA" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "VD_TIPO", nullable = false)
    private TipoVendaEnum tipo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "VD_STATUS", nullable = false)
    private StatusVendaEnum status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "US_ID")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoVendaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoVendaEnum tipo) {
        this.tipo = tipo;
    }

    public StatusVendaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusVendaEnum status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
