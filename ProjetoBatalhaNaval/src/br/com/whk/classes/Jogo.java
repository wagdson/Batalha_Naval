/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.whk.classes;

import br.com.whk.classes.Arma;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author WAGDSON
 */
public class Jogo {

    private int tamanho = 0;
    private Arma[][] tabuleiro = null;
    private ArrayList<Jogador> arrayJogador = null;
    private int totalDeArmas = 0;

    // metodo ser jogaro na lista
    public Jogo(int tamanho) throws Exception {
        if (tamanho < 3) {
            throw new Exception("tamanho não pode ser < 3!");
        }
     
        Random gerador = new Random();
        tabuleiro = new Arma[tamanho][tamanho];
        arrayJogador = new ArrayList<>();

        int porcentagemArmas = (int) (((tamanho * tamanho) * 0.6) * 0.3);
        totalDeArmas += porcentagemArmas;
      
        for (int i = 0; i < porcentagemArmas; i++) {
            int linha = gerador.nextInt(tamanho);
            int coluna = gerador.nextInt(tamanho);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Arma("Porta Avião", 5, 'P', true);
            } else {
                i--;
            }

        }
        porcentagemArmas = (int) (((tamanho * tamanho) * 0.6) * 0.3);
        totalDeArmas += porcentagemArmas;
        for (int i = 0; i < porcentagemArmas; i++) {
            int linha = gerador.nextInt(tamanho);
            int coluna = gerador.nextInt(tamanho);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Arma("Submarino", 5, 'S', true);

            } else {
                i--;
            }

        }
        porcentagemArmas = (int) (((tamanho * tamanho) * 0.6) * 0.2);
        totalDeArmas += porcentagemArmas;
        for (int i = 0; i < porcentagemArmas; i++) {
            int linha = gerador.nextInt(tamanho);
            int coluna = gerador.nextInt(tamanho);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Arma("Cruzador", 4, 'C', true);
            } else {
                i--;
            }

        }
        porcentagemArmas = (int) (((tamanho * tamanho) * 0.6) * 0.2);
        totalDeArmas += porcentagemArmas;
        for (int i = 0; i < porcentagemArmas; i++) {
            int linha = gerador.nextInt(tamanho);
            int coluna = gerador.nextInt(tamanho);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = new Arma("Destroier", 3, 'D', true);
            } else {
                i--;
            }

        }

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == null) {
                    tabuleiro[i][j] = new Arma("Livre", 0, 'L', true);
                }

            }

        }
   

    }

    // disparo e linha e coluna
    public String disparar(int linha, int coluna) throws Exception {
        System.out.println("Total de armas: " + totalDeArmas);
         if (totalDeArmas == 0) {
                    return "Jogo Finalizado";

               }

        if (tabuleiro[linha][coluna].isSituacao() == true) {
            String aux = String.valueOf(tabuleiro[linha][coluna].getSimbolo() + "," + tabuleiro[linha][coluna].getPontos());
            tabuleiro[linha][coluna].setSituacao(false);
            if (tabuleiro[linha][coluna].getSimbolo() != 'L') {
                totalDeArmas--;
               

            }

            return aux;
        }
        return "";
    }

    public char getSimbolo(int linha, int coluna) {
        char simbolo = tabuleiro[linha][coluna].getSimbolo();
        return simbolo;
    }

    /**
     * @return the arrayJogador
     */
    /**
     * @param arrayJogador the arrayJogador to set
     */
}
