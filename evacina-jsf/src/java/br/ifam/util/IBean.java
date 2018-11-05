/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.util;

/**
 *
 * @author fernando
 */
public interface IBean <T>{
    public String salva();
    public String excluir(T ob);
    public String visualiza(T ob);
    public String alterar();
}
