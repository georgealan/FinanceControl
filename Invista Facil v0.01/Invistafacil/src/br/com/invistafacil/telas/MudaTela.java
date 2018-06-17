/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.invistafacil.telas;

/**
 *
 * @author George Alan
 */
import javax.swing.JPanel;

public class MudaTela {
    //
    private JPanel container;
    private JPanel content;


    /**
     * Construtor de classe
     */
    public MudaTela(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }

}//--> fim da classe
