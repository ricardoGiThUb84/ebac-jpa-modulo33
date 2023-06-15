package org.ebac.modulo33.repository;

import org.ebac.modulo33.model.Carro;
import org.ebac.modulo33.model.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaRepository implements IRepository<Marca, Long> {

    private EntityManager entityManager;

    public MarcaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Marca marca) {

        entityManager.persist(marca);

    }

    @Override
    public Marca buscar(String nome) {
        return null;
    }
}
