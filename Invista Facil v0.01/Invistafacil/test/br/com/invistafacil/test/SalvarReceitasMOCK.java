/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.test;

import br.com.invistafacil.business.ReceitasBusiness;
import br.com.invistafacil.business.interfaces.ReceitasInterface;
import br.com.invistafacil.dominio.Receitas;
import javax.swing.JOptionPane;

/**
 *
 * @author George Alan
 */
public class SalvarReceitasMOCK {

    public static void main(String agrs[]) {

        try {
            Receitas adicaoReceita = new Receitas();
            adicaoReceita.setDescricao("Pagamento do freela");
            adicaoReceita.setValor(7595);
            adicaoReceita.setFormaRecebimento("Débito Conta Corrente");
            adicaoReceita.setTipo("Salário");
            adicaoReceita.setDataDia("10/06/2018");

            ReceitasInterface receitasBusiness = new ReceitasBusiness();
            if (receitasBusiness.salvarReceitas(adicaoReceita) != null) {
                JOptionPane.showMessageDialog(null, "Receita adicionada com sucesso!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a receita!" + ex);
        }
    }
}
