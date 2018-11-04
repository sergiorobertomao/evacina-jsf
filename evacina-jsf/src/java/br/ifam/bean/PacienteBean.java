/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.bean;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Paciente;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author gustav0
 */
@ManagedBean 
public class PacienteBean {
    
    private String nome;
    private long sus;
    private String data;
    private String sexo;
    
    private String pesquisa;
    
    private List<Paciente> pacientes;
    
    /**
     * Lista pacientes logo que carregar pagina
     */
    public PacienteBean() {
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        pacientes = dao.findAll(Paciente.class);
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getSus() {
        return sus;
    }

    public void setSus(long sus) {
        this.sus = sus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    /**
     * Funções do crud
     */
    public String salva(){
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        Paciente paciente = new Paciente(sus, nome, sexo, data);
        dao.save(paciente);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String excluir(Paciente paciente){
       GenericoDAO dao = new GenericoDAO();
       dao.remove(Paciente.class, paciente.getSus());
       return "index.xhtml?faces-redirect=true";
    }
    
    public String visualiza(Paciente paciente){
        this.data = paciente.getNascimento();
        this.nome = paciente.getNome();
        this.sexo = paciente.getSexo();
        this.sus = paciente.getSus();
        return "alterar.xhtml";
    }
    
    public String alterar(){
        GenericoDAO dao = new GenericoDAO();
        Paciente paciente = new Paciente(sus, nome, sexo, data);
        dao.update(paciente);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String pesquisar(){
        GenericoDAO dao = new GenericoDAO();
        pacientes.clear();
        pacientes = dao.findByNome(Paciente.class, pesquisa, "nome");
        return "index.xhtml";
    }
}
