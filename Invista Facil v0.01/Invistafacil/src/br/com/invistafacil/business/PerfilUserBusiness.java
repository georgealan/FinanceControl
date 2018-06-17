/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.PerfilUserInterface;
import br.com.invistafacil.dominio.Usuario;
import br.com.invistafacil.repositorio.ConexaoDB;
import br.com.invistafacil.repositorio.Sessao;
import br.com.invistafacil.repositorio.UsuarioLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class PerfilUserBusiness implements PerfilUserInterface{
    ConexaoDB conectaBd = ConexaoDB.getInstancy(); //Instancia a classe para conectar com o banco de dados.
    Usuario usr = new Usuario(); //Instancia o usuario.
    ContaBancoBusiness bankCad = new ContaBancoBusiness(); //Instancia a classe ContaBusiness.
    

    @Override
    public Usuario updateUsuario(Usuario usuario) { 
        
        try {
            Connection con = conectaBd.getConexao();
            String sql = "UPDATE USUARIO set USERNAME=?, EMAIL=?, SENHA=?, NOME=?, SOBRENOME=?, CPF=?, RG=? WHERE ID_USUARIO=?";
            
            PreparedStatement pst = conectaBd.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getUsername());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getNome());
            pst.setString(5, usuario.getSobrenome());
            pst.setDouble(6, usuario.getCpf());
            pst.setDouble(7, usuario.getRg());
            pst.setInt(8, usuario.getId());
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer update dos dados");
        }
        conectaBd.desconecta(); // TESTANDO BUGS, REMOVER DEPOIS.
        return null; 
    }   

    
}
