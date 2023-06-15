package org.ebac.modulo33.repository;

public interface IRepository<T, E> {


    void salvar(T t);

    T buscar(String nome);




}
