/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.test;

import br.com.invistafacil.business.LoginBusiness;
import br.com.invistafacil.business.interfaces.LoginInterface;
import br.com.invistafacil.dominio.Usuario;
import br.com.invistafacil.telas.MudaTela;
import javax.swing.JOptionPane;



/**
 *
 * @author internet
 */
public class LoginInterfaceMOCK {
   
   public static void main(String agrs[]){
       
        try {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setEmail("george@george");
            novoUsuario.setSenha("123");
            
            LoginInterface loginBusiness = new LoginBusiness();
            
            if(loginBusiness.validaUsuario(novoUsuario)!=null) {
                JOptionPane.showMessageDialog(null, "Usuario logado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou usuario invalidos");
            }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Senha ou usuario invalidos");
        }
   }
}
