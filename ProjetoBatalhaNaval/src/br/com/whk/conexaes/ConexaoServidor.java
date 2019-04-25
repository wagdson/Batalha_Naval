/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.whk.conexaes;

import br.com.whk.classes.Jogador;
import br.com.whk.classes.Jogo;
import br.com.whk.telas.TelaJogo;
import static br.com.whk.telas.TelaJogo.getTamanho;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConexaoServidor extends Thread {

    private static ArrayList<Jogador> jogadores = new ArrayList<>();
    private ServerSocket serverConexao;

    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;
    private static TelaJogo tela = null;
    private static int cont = 1;
    private int contador = 0;
    private static int vezJogador = 1;

    /**
     * Método construtor
     *
     * @param com do tipo Socket
     */
    public ConexaoServidor(Socket con) {
        this.con = con;
        try {
            in = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConexaoServidor() throws IOException {

        serverConexao = new ServerSocket(Integer.parseInt("12345"));

        while (contador < 3) {
            System.out.println("Aguardando conexão...");
            Socket con = serverConexao.accept();
            System.out.println("Cliente conectado...");
            Thread t = new ConexaoServidor(con);

            String msg = String.valueOf(getTamanho());
            PrintWriter out = new PrintWriter(con.getOutputStream(), true);
            out.println(msg);

            t.start();

            contador++;

        }

    }

    /**
     * Método run
     */
    public void run() {

        try {

            this.con.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader bfr = new BufferedReader(inr);
            String msg = "";
          

            msg = bfr.readLine();

            Jogador jogador = new Jogador(cont, msg);
            cont++;

            jogadores.add(jogador);
            tela.setJogadores(jogador.getNome());

       
            while (true) {

                PrintWriter out = new PrintWriter(con.getOutputStream(), true);

                msg = bfr.readLine();
                if (vezJogador == jogador.getId()||vezJogador ==4) {

                    int linha = Character.getNumericValue(msg.charAt(2));
                    int coluna = Character.getNumericValue(msg.charAt(0));
                    String aux = getTela().disparar(linha, coluna);

                    if (aux.equals("Jogo Finalizado")) {        
                         out.println("Jogo Finalizado");
                         vezJogador = 4;
                         
                        int maior = jogadores.get(0).getPontos();
                        String ganhador = jogadores.get(0).getNome() + "";
                        String pontosGanhador = jogadores.get(0).getPontos() + "";
                        for (int i = 1; i < jogadores.size(); i++) {
                            if (jogadores.get(i).getPontos() > maior) {
                                maior = jogadores.get(i).getPontos();
                                ganhador = jogadores.get(i).getNome() + "";
                                pontosGanhador = jogadores.get(i).getPontos() + "";
                            }
                        }
                        aux = "Jogo Finalizado! ";
                        out.println(aux);
                        aux = "Vencedor: " + ganhador + "";
                        out.println(aux);
                        aux = "Pontos: " + pontosGanhador + "";
                        out.println(aux);
                    } else {
                         if (aux.equals("Jogo Finalizado")) {
                       
                        out.println(aux);
                    }
                        out.println(aux);
                        if (!(aux.equals(""))) {
                            int pontos = Character.getNumericValue(aux.charAt(2));
                            jogador.setPontos(pontos);
                           // jogadores.get(jogador.getId() -1).setPontos(pontos);
                        }
                        tela.setPontos(jogador.getId(), jogador.getPontos());
                      
                        gerenciandoTreads();
                    }
                } else {
                    out.println("não liberado");
                   
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void sendToAll(String msg) throws IOException {
        BufferedWriter bwS;

        //  bw.write(nome + " -> " + msg + "\r\n");
        //  bw.flush();
    }

    /**
     * *
     * Método main
     *
     * @param args
     */
    public static void gerenciandoTreads() {
        if (vezJogador == 1) {
            vezJogador = 2;
        } else if (vezJogador == 2) {
            vezJogador = 3;
        } else if (vezJogador == 3) {
            vezJogador = 1;
        }

    }

    public static void setTela(TelaJogo obTela) {

        tela = obTela;

    }

    public TelaJogo getTela() {
        return tela;
    }

    public static void main(String args[]) throws IOException, Exception {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaJogo tela = new TelaJogo();
                    tela.setVisible(true);
                    setTela(tela);
                } catch (Exception ex) {
                    Logger.getLogger(TelaJogo.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }
            }
        });
        ConexaoServidor servidor = new ConexaoServidor();

    }

    // Fim do método main
    /**
     * @return the clientes
     */
} //Fim da classe
