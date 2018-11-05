package br.ifam.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Atendente implements Serializable {

    @Id
    private Long id;
    private String nome;
    private String senha;

    public Atendente() {
    }

    public Atendente(long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }


    public Atendente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
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
}
