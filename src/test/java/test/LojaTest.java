package test;

import org.ebac.modulo33.model.*;
import org.ebac.modulo33.repository.AcessoriosRepository;
import org.ebac.modulo33.repository.CarroRepository;
import org.ebac.modulo33.repository.MarcaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class LojaTest {

    final String  PERSISTENCE_UNIT = "loja-carro";

    @Test
    public void buscarProdutos(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        AcessoriosRepository acessoriosRepository = new AcessoriosRepository(entityManager);

         CarroRepository carroRepository = new CarroRepository(entityManager);

        entityManager.getTransaction().begin();

        Acessorios airBag = acessoriosRepository.buscar("AIR bag");

         Carro polo = carroRepository.buscar("POLO");

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        Assertions.assertNotNull(airBag);
        Assertions.assertNotNull(polo);

        System.out.println(polo);
        System.out.println(airBag);


    }


    @Test
    public void salvarProdutos() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Marca marca = new Marca("Hyundai", "Coréia do Sul");

        Acessorios acessorios = new Acessorios(TipoAcessorio.SEGURANÇA, new BigDecimal("315.68"), "air bag");

        Carro carro = new Carro("hb20", Tipo.HATCH, "CHW6060", marca, acessorios);

        CarroRepository carroRepository = new CarroRepository(entityManager);
        MarcaRepository marcaRepository = new MarcaRepository(entityManager);
        AcessoriosRepository acessoriosRepository = new AcessoriosRepository(entityManager);

        entityManager.getTransaction().begin();

        marcaRepository.salvar(marca);
        carroRepository.salvar(carro);
        acessoriosRepository.salvar(acessorios);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();




    }


}
