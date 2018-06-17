/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.repositorio;

import br.com.invistafacil.dominio.ContaBanco;
import br.com.invistafacil.dominio.Despesas;
import br.com.invistafacil.dominio.Receitas;
import br.com.invistafacil.dominio.Usuario;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class ConexaoDB {

    public Statement stm;
    public ResultSet rs;
    private String driver = "org.h2.Driver";
    private String caminho = "jdbc:h2:file:./repositorios/invistafacilDB";
    private String usuario = "sa";
    private String senha = "";
    private Connection con;
    private static ConexaoDB instancy;

    //Método responsável pela conexão do banco de dados.
    private ConexaoDB() {   
        try {
            System.setProperty("jdbc.Drivers", driver);
            this.con = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar se conectar! com o banco de dados:\n" + ex.getMessage());
        }
    }
    
    public static ConexaoDB getInstancy(){
        if(instancy == null){
            instancy = new ConexaoDB();
        }
        return instancy;
    }
    
    public Connection getConexao(){
        return this.con;
    }
    
    //Método responsável por desligar o banco de dados.
    public void desconecta() {    
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados:\n!" + ex.getMessage());
        }
    }

    //Método para executar os selects.
    public void pesquisarSql(String sql) {
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ExecutarSql:\n!" + ex.getMessage());
        }
    }

    //Método para inserir, excluir e atualizar (insert, delete, update)
    public void atualizar(String sql) {
        try {
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ExecutarSql:\n!" + ex.getMessage());
        }
    }

}
