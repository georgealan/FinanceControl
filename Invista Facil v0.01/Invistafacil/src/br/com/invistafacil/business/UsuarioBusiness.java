/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.UsuarioInterface;
import br.com.invistafacil.dominio.Usuario;
import br.com.invistafacil.repositorio.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class UsuarioBusiness implements UsuarioInterface{

    ConexaoDB conectaBd = ConexaoDB.getInstancy();
    
    
    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        Connection con = conectaBd.getConexao();
        
        try {           
            PreparedStatement pst = conectaBd.getConexao().prepareStatement("insert into USUARIO (USERNAME,EMAIL,SENHA,NOME,SOBRENOME,CPF,RG) values (?,?,?,?,?,?,?)");
            pst.setString(1, usuario.getUsername());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getNome());
            pst.setString(5, usuario.getSobrenome());
            pst.setDouble(6, usuario.getCpf());
            pst.setDouble(7, usuario.getRg());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Parabéns! você é um novo usuário do Invista Fácil!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o cadastro!" + ex);
        }  
        //conectaBd.desconecta();
        return null;
    }
   

}
