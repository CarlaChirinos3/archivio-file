package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        //INIZIALIZZARE PORTE 
        ServerSocket ss=new ServerSocket(300);
        Socket s=ss.accept();
        //CONDIZIONE
        boolean condizione=true;

        while(condizione==true){
                    //TUBI
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8), true);

            String richiesta = in.readLine();
            if(richiesta==null){
                //fine connessione
                condizione = false;
                break;
            }else if(richiesta.isEmpty()==false){
                out.println("ERR SINTAX");
                break;
            }
            String[] parti = richiesta.trim().split("\\s+");
            if(parti.length<2){
                out.println("ERR SINTAX");
                break;
            }
            switch(parti[0]){
                case "LEGGI":
                    if (parti.length!=2) {
                        out.println("ERR SINTAX");
                        break;
                    }
                    //se è corretto 
                    //CONTROLLA SE IL FILE SIA ESISTENTE
                    File cartella = new File("documenti");
                    File file = new File(cartella, nomeFile);

                    break;
                default:
                    out.println("\t ERR UNKNOWNCMD");
                    break;

            }
        // Se richiesta è null, terminate la gestione di questa connessione.
        // Altrimenti, se richiesta.trim().isEmpty(), rispondete ERR SYNTAX.
        // Solo dopo questi controlli:

        }
}
}