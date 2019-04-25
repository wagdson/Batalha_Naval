/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.whk.classes;

import javax.swing.JOptionPane;

/**
 *
 * @author WAGDSON
 */
public class Arma {
    
    private String descricao = "";
    private int pontos = 0;
    private char simbolo = 0;
    private boolean situacao = true; 

    
 
    public Arma(String descricao, int pontos, char simbolo, boolean situacao) throws Exception{
        try {
            this.descricao = descricao;
            this.pontos = pontos;
            this.simbolo = simbolo;
            this.situacao = situacao;             
        } catch (Exception e) {
            throw e;
        }
       
    }
 
    /**
     * @return the descricao
     */
    public String getDescricao() {
        
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) throws Exception {
         if (descricao.isEmpty()) throw new Exception ("Descrição está vazia");
        this.descricao = descricao;
    }

    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) throws Exception {
         if (pontos < 0) throw new Exception ("pontos não poder ser negativo");
        this.pontos = pontos;
    }

    /**
     * @return the simbolo
     */
    
    
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo( char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the situacao
     */
    public boolean isSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

}
