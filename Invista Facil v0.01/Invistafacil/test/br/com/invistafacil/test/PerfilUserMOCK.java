/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.test;

import br.com.invistafacil.business.PerfilUserBusiness;
import br.com.invistafacil.business.interfaces.PerfilUserInterface;
import br.com.invistafacil.dominio.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class PerfilUserMOCK {
    
    public static void main(String agrs[]){
           
        try{
            Usuario usuario = new Usuario();
            usuario.setUsername("Mario");
            usuario.setEmail("mario@mario");
            usuario.setSenha("123");
            usuario.setNome("Mario");
            usuario.setSobrenome("Bros");
            usuario.setCpf(2);
            usuario.setRg(3);
            usuario.setId(42);
                          
            PerfilUserInterface perfilUserBusiness = new PerfilUserBusiness();
            
            if(perfilUserBusiness.updateUsuario(usuario)!=null){
                JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer update dos dados");
        }
    }  
}
