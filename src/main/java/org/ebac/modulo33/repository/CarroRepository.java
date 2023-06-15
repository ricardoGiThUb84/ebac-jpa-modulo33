package org.ebac.modulo33.repository;

import org.ebac.modulo33.model.Acessorios;
import org.ebac.modulo33.model.Carro;

import javax.persistence.EntityManager;

public class CarroRepository implements IRepository<Carro, Long> {

    private EntityManager entityManager;


    public CarroRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Carro carro) {
        entityManager.persist(carro);
    }

    @Override
    public Carro buscar(String modelo) {
        String query = "SELECT c FROM Carro c WHERE c.modelo LIKE :modelo";
        return entityManager.createQuery(query, Carro.class)
                .setParameter("modelo", "%" + modelo + "%").getSingleResult();
    }
}
