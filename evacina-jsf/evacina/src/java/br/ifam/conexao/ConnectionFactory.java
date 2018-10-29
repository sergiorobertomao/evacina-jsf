/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fernando
 */
public class ConnectionFactory {

    private static EntityManagerFactory em;

    public static EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            System.out.println("Criando EntityManager....");
            em = Persistence.createEntityManagerFactory("DRA_PROJETO_JSF_JPA_PRIMEFACES");
        }
        return em.createEntityManager();
    }

    public static void closeEntityFactory() {
        em.close();
    }
}
