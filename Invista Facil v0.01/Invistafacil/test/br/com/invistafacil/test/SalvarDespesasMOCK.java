/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.test;

import br.com.invistafacil.business.DespesasBusiness;
import br.com.invistafacil.business.interfaces.DespesasInterface;
import br.com.invistafacil.dominio.Despesas;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class SalvarDespesasMOCK {
    
    public static void main(String agrs[]){
        
        try{            
            Despesas adicaoDespesa = new Despesas();
            adicaoDespesa.setDescricao("Compra do mê de junho");
            adicaoDespesa.setValor(895);
            adicaoDespesa.setFormaPagamento("Dinheiro");
            adicaoDespesa.setTipo("Casa");
            adicaoDespesa.setDataDia("02/06/2018");
            
            DespesasInterface despesasBusiness = new DespesasBusiness();
            
            if(despesasBusiness.salvarDespesas(adicaoDespesa)!=null){
                JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a despesa!" + ex);
        }
    } 
}
