/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.repositorio;

/**
 *
 * @author George Alan
 */
public class UsuarioLogado {

    private String nome;
    private Integer ID;

    public UsuarioLogado() {
    }

    private static class UsuarioLogadoHolder {

        private final static UsuarioLogado instance = new UsuarioLogado();
    }

    public static UsuarioLogado getInstance() {
        return UsuarioLogadoHolder.instance;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        ID = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
