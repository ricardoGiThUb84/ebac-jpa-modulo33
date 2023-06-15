package org.ebac.modulo33.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    private String chassi;

    @ManyToOne
    @JoinColumn(name = "marca_carro_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "tb_carro_acessorios",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private Set<Acessorios> acessorios = new HashSet<>();

    public Carro() {
    }

    public Carro(String modelo, Tipo tipo, String chassi, Marca marca, Acessorios acessorios) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.chassi = chassi;
        this.marca = marca;
        this.acessorios.add(acessorios);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Acessorios acessorios) {
        this.acessorios.add(acessorios);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", chassi='" + chassi + '\'' +
                ", marca=" + marca +
                '}';
    }
}
