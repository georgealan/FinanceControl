/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.ContaBancoInterface;
import br.com.invistafacil.dominio.ContaBanco;
import br.com.invistafacil.repositorio.ConexaoDB;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class ContaBancoBusiness implements ContaBancoInterface{
    ConexaoDB conectaBd = ConexaoDB.getInstancy();

    @Override
    public ContaBanco salvarContaBanco(ContaBanco contaBanco) {
        
        try {
            Connection con = conectaBd.getConexao();
            String sql = "insert into CONTA (CONTA_TIPO,BANCO,NUMERO,SALDO) values (?,?,?,?)";
            
            PreparedStatement pst = conectaBd.getConexao().prepareStatement(sql);
            
            pst.setString(1, contaBanco.getContaTipo());
            pst.setString(2, contaBanco.getBanco());
            pst.setInt(3, contaBanco.getNumeroConta());
            pst.setDouble(4, contaBanco.getSaldo());
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Conta bancária salva com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o cadastro!" + ex);
        }
        conectaBd.desconecta(); 
        return null;   
    }   
}
