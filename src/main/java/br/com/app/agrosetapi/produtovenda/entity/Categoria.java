package br.com.app.agrosetapi.produtovenda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import javax.persistence.Transient;
import java.util.List;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_CATEGORIA", schema = "public")
@SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "public.SEQ_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATEGORIA")
    @Column(name = "CT_ID", nullable = false)
    private Long id;

    @Column(name = "CT_NOME", nullable = false)
    private String nome;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CT_ID_PAI")
    @JsonBackReference(value="pai")
    private Categoria pai;

    @Transient
    private List<Categoria> filhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getPai() {
        return pai;
    }

    public void setPai(Categoria pai) {
        this.pai = pai;
    }

    public List<Categoria> getFilhas() {
        return filhas;
    }

    public void setFilhas(List<Categoria> filhas) {
        this.filhas = filhas;
    }
}
