package org.ebac.modulo33.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_acessorios")
public class Acessorios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(value = EnumType.STRING)
    private TipoAcessorio tipoAcessorio;

    private BigDecimal valor;

    @ManyToMany(mappedBy = "acessorios")
    private Set<Carro> carros = new HashSet<>();

    public Acessorios() {
    }

    public Acessorios(TipoAcessorio tipoAcessorio, BigDecimal valor, String nome) {
        this.tipoAcessorio = tipoAcessorio;
        this.valor = valor;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAcessorio getTipoAcessorio() {
        return tipoAcessorio;
    }

    public void setTipoAcessorio(TipoAcessorio tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Carro carros) {
        this.carros.add(carros);
    }

    @Override
    public String toString() {
        return "Acessorios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoAcessorio=" + tipoAcessorio +
                ", valor=" + valor +
                '}';
    }
}
