/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.bean;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Atendente;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author gustav0
 */

@ManagedBean
public class AtendenteBean {
    private Long id;
    private String nome;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public void salvar(){
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = new Atendente(nome, senha);
        dao.save(atendente);
    }
    
    public void login(){
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = dao.findById(Atendente.class, id);
        
        if(atendente!=null){
            if(atendente.getSenha().equals(senha)){
                System.out.println("Entrou usuário");
            }else{
                System.out.println("Senha errada");
            }
        }
        
    }

    
}
