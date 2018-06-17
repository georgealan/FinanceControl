/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.DespesasInterface;
import br.com.invistafacil.dominio.Despesas;
import br.com.invistafacil.repositorio.ConexaoDB;
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
public class DespesasBusiness implements DespesasInterface {

    ConexaoDB conectaBd = ConexaoDB.getInstancy();

    @Override
    public Despesas salvarDespesas(Despesas despesas) {

        try {
            Connection con = conectaBd.getConexao();
            String sql = "insert into DESPESAS (DESCRICAO,VALOR,FORMA_PAGAMENTO,TIPO,DATA_DIA) values (?,?,?,?,?)";

            PreparedStatement pst = conectaBd.getConexao().prepareStatement(sql);

            pst.setString(1, despesas.getDescricao());
            pst.setDouble(2, despesas.getValor());
            pst.setString(3, despesas.getFormaPagamento());
            pst.setString(4, despesas.getTipo());
            pst.setString(5, despesas.getDataDia());
            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a despesa!" + ex);
        }
        conectaBd.desconecta();
        return null;
    }
}
