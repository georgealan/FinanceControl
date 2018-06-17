/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business;

import br.com.invistafacil.business.interfaces.LoginInterface;
import br.com.invistafacil.dominio.ContaBanco;
import br.com.invistafacil.dominio.Usuario;
import br.com.invistafacil.repositorio.ConexaoDB;
import br.com.invistafacil.repositorio.Sessao;
import br.com.invistafacil.repositorio.UsuarioLogado;
import br.com.invistafacil.telas.MudaTela;
import br.com.invistafacil.telas.PerfilUserTela;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author George Alan
 */
public class LoginBusiness implements LoginInterface {

    ConexaoDB conectaBd = ConexaoDB.getInstancy(); //Instancia a classe para conectar com o banco de dados.
    Usuario usr = new Usuario(); //Instancia o usuario.
    ContaBanco bank = new ContaBanco(); //Instancia a classe ContaBanco.
    PerfilUserBusiness cadastro = new PerfilUserBusiness(); //Instancia o business do PerfilUser.
    ContaBancoBusiness bankCad = new ContaBancoBusiness(); //Instancia a classe ContaBusiness.

    @Override
    public Usuario validaUsuario(Usuario usuarioLogado) {
        try {
            String sql = "SELECT * FROM USUARIO where EMAIL='" + usuarioLogado.getEmail() + "'";

            conectaBd.pesquisarSql(sql);

            conectaBd.rs.first();
            if (conectaBd.rs.getString("SENHA").equals(usuarioLogado.getSenha())) {

                usuarioLogado.setId(conectaBd.rs.getInt("ID_USUARIO"));
                usuarioLogado.setCpf(conectaBd.rs.getInt("CPF"));
                usuarioLogado.setNome(conectaBd.rs.getString("NOME"));
                usuarioLogado.setEmail(conectaBd.rs.getString("EMAIL"));
                usuarioLogado.setRg(conectaBd.rs.getInt("RG"));
                usuarioLogado.setSenha(conectaBd.rs.getString("SENHA"));
                usuarioLogado.setSobrenome(conectaBd.rs.getString("SOBRENOME"));
                usuarioLogado.setUsername(conectaBd.rs.getString("USERNAME"));
                                      
                UsuarioLogado.getInstance().setID(conectaBd.rs.getInt("ID_USUARIO"));
                UsuarioLogado.getInstance().setNome(conectaBd.rs.getString("USERNAME"));
 
                PerfilUserTela userAtivo = new PerfilUserTela();
                userAtivo.mostraDados();
                
            } else {
                return null;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Senha ou usuario invalidos");
        }
        conectaBd.desconecta();
        return usuarioLogado;
        
    }

}
