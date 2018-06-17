/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.repositorio;

import br.com.invistafacil.dominio.Usuario;

/**
 *
 * @author George Alan
 */
public class Sessao {

    private static Sessao instance = null;
    private Usuario usuario;

    private Sessao() {
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }
}

/**
 * Durante o sistema vc descobre o usuario logado com esse comando:
 *
 * Sessao.getInstance().getUsuario();
 *
 * Colocar isso nas telas abaixo do inicio da conexão, com exeção da tela onde
 * deu inicio o login do usuário.
 *
 * Com o comando abaixo:
 *
 * Sessao sessao = Sessao.getInstance(); sessao.setUsuario(usuario); - setar o
 * usuario.
 *
 * Serve para manter o usuário logado durante o uso do sistema esse código é
 * executado pós login.
 */

