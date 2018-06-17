/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.test;

import br.com.invistafacil.business.ContaBancoBusiness;
import br.com.invistafacil.business.interfaces.ContaBancoInterface;
import br.com.invistafacil.dominio.ContaBanco;
import br.com.invistafacil.dominio.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class ContaBancoMOCK {
    
    public static void main(String agrs[]){
        
        try {
            ContaBanco contaBancaria = new ContaBanco();
            contaBancaria.setContaTipo("Corrente");
            contaBancaria.setBanco("Santander");
            contaBancaria.setNumeroConta(96785);
            contaBancaria.setSaldo(540);
            
            ContaBancoInterface contaBancoBusiness = new ContaBancoBusiness();
            
            if(contaBancoBusiness.salvarContaBanco(contaBancaria)!=null){
                JOptionPane.showMessageDialog(null, "Conta bancária salva com sucesso!");
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o cadastro!" + ex);
        }          
    }   
}
