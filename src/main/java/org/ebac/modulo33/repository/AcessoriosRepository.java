package org.ebac.modulo33.repository;

import org.ebac.modulo33.model.Acessorios;
import org.ebac.modulo33.model.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AcessoriosRepository implements IRepository<Acessorios, Long> {

    private EntityManager entityManager;

    public AcessoriosRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Acessorios acessorios) {
        entityManager.persist(acessorios);
    }

    @Override
    public Acessorios buscar(String nome) {
        String query = "SELECT a FROM Acessorios a WHERE a.nome LIKE :nome";
         return entityManager.createQuery(query, Acessorios.class)
                .setParameter("nome", "%" + nome + "%").getSingleResult();
    }
}
