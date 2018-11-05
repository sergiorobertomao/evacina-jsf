/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.dao;

import br.ifam.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fernando
 */
public class GenericoDAO<T extends Serializable> {

   

    public GenericoDAO() {
        
    }

    public T findById(Class<T> clazz, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T t = (T) session.get(clazz, id);
        session.close();
        return t;
    }

    public void remove(Class<T> clazz, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("excluindo.." + clazz.getName());
        T t = findById(clazz, id);
        try {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public void save(T obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("salvando.." + obj.getClass().getName());
        try {
            session.beginTransaction();
            session.persist(obj);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public void update(T obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("alterando.." + obj.getClass().getName());
        try {
            session.beginTransaction();
            session.merge(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    public List<T> findAll(Class<T> obj){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("Select t from " + obj.getSimpleName() + " t").list();
    }
    public List<T> findByNome(Class<T> obj, String procura, String coluna){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select t from " + obj.getSimpleName() + " as t WHERE t."+coluna+" LIKE :param");
        query.setParameter("param", "%"+procura+"%");
        return query.list();
    }
}
