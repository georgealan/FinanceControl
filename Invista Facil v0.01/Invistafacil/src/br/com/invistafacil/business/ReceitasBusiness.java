/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.ReceitasInterface;
import br.com.invistafacil.dominio.Receitas;
import br.com.invistafacil.repositorio.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class ReceitasBusiness implements ReceitasInterface {
    
    ConexaoDB conectaBd = ConexaoDB.getInstancy();
    
    @Override
    public Receitas salvarReceitas(Receitas receitas) {
        
        try {
            Connection con = conectaBd.getConexao();
            
            String sql = "insert into RECEITA (DESCRICAO,VALOR,FORMA_RECEBIMENTO,TIPO,DATA_DIA) values (?,?,?,?,?)";
            
            PreparedStatement pst = conectaBd.getConexao().prepareStatement(sql);
            
            pst.setString(1, receitas.getDescricao());
            pst.setDouble(2, receitas.getValor());
            pst.setString(3, receitas.getFormaRecebimento());
            pst.setString(4, receitas.getTipo());
            pst.setString(5, receitas.getDataDia());
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Receita adicionada com sucesso!");  
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a receita!" + ex);
        }
        conectaBd.desconecta();
        return null;       
    }

}
