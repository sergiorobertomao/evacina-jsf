/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author fernando
 */
public class GenericoDAO<T extends Serializable> {

    private static EntityManager entityManager;

    public GenericoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T findById(Class<T> clazz, Long id) {
        System.out.println("bucando por id.." + clazz.getName());
        return entityManager.find(clazz, id);
    }

    public void remove(Class<T> clazz, Long id) {
        System.out.println("excluindo.." + clazz.getName());
        T t = findById(clazz, id);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void save(T obj) {
        System.out.println("salvando.." + obj.getClass().getName());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(T obj) {
        System.out.println("alterando.." + obj.getClass().getName());
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
