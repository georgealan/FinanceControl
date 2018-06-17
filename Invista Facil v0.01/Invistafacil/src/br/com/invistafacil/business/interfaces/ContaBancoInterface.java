/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.business.interfaces;

import br.com.invistafacil.dominio.ContaBanco;

/**
 *
 * @author George Alan
 */
public interface ContaBancoInterface{
    
    //Método responsável por cadastrar a conta bancária do usuário na database.
    public ContaBanco salvarContaBanco(ContaBanco contaBanco);
   
            
    }
    
        
    

