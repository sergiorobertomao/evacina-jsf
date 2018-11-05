/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.bean;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Atendente;
import java.util.List;
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

    private String pesquisa;
    
    private List<Atendente> atendentes;

    public AtendenteBean() {
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        atendentes = dao.findAll(Atendente.class);
    }
    
    
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

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<Atendente> atendentes) {
        this.atendentes = atendentes;
    }
    
    
    
    public String salvar(){
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = new Atendente(id,nome, senha);
        dao.save(atendente);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String excluir(Atendente atendente){
        GenericoDAO dao = new GenericoDAO();
        dao.remove(Atendente.class, atendente.getId());
        return "index.xhtml?faces-redirect=true";
    }
    
    public String visualizar(Atendente atendente){
        this.id = atendente.getId();
        this.nome = atendente.getNome();
        this.senha = atendente.getSenha();
        return "alterar.xhtml";
    }
    
    public String alterar(){
        GenericoDAO dao = new GenericoDAO();
        Atendente atendente = new Atendente(id,nome, senha);
        dao.update(atendente);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String pesquisar(){
        GenericoDAO dao = new GenericoDAO();
        atendentes.clear();
         atendentes = dao.findByNome(Atendente.class, pesquisa, "nome");
        return "index.xhtml";
    }
    
    public String login(){
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = dao.findById(Atendente.class, id);
        
        if(atendente!=null){
            if(atendente.getSenha().equals(senha)){
                return "/admin/index.xhtml?faces-redirect=true";
            }else{
               return "login.xhtml";
            }
        }
        return "login.xhtml";
    }

    
}
