/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.whk.classes;

/**
 *
 * @author kod4k
 */
public class Jogador {
    private int id = 0;
    private String nome = "";
    private int pontos = 0;

    public Jogador(int id, String nome) throws Exception{
        
            this.id = id;
            this.nome = nome;
          
   
    }

    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) throws Exception{
        if(id <1) throw new Exception("id não pode ser igual ou menor que zero!");
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome)throws Exception {
          if (nome.isEmpty()) throw new Exception ("nome está vazia");
        
        this.nome = nome;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) throws Exception {
        if (pontos < 0) throw new Exception ("pontos não poder ser negativo");
        this.pontos += pontos;
    }
}
