package Model.DAO;


import Model.Fiat;
import Model.Cripto;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jp
 */
public class Banco {
    
    public static ArrayList<Servico> servico;
    public static ArrayList<Fiat> fiat;
    public static ArrayList<Cripto> cripto;
    public static ArrayList<Usuario> usuario;
   
    
    
    public static void inicia(){
    
        //Instancia os Objetos        
        servico= new ArrayList<Servico>();
        fiat= new ArrayList<Fiat>();
        cripto= new ArrayList<Cripto>();
        servico = new ArrayList<Servico>();
        usuario = new ArrayList<Usuario>();
        //criando elementos
        Usuario usuario1 = new Usuario("joao", "joao", 2000, 0.00826446f);
        Usuario usuario2= new Usuario("professor", "professor", 2000, 0.00826446f);
        
       
        
        Cripto cripto1 = new Cripto(0,"BTC","Bitcoin",242000f, 0);
        Cripto cripto2 = new Cripto(1,"ETH","Etherium", 16000.00f, 0);
        Cripto cripto3 = new Cripto(2,"ADA","Cardano", 10.90f,0);  
        Cripto cripto4 = new Cripto(3,"BNB","BinanceCoin", 2213f,0);
        Cripto cripto5 = new Cripto(4,"DOGE","DogeCoin", 1.70f,0);
        Cripto cripto6 = new Cripto(5,"SOL","SOLANA", 337f,0);
        Cripto cripto7 = new Cripto(6,"XVG","VERGE", 0.18f,0);
        Cripto cripto8 = new Cripto(7,"LTC","LITCOIN", 950f,0);
        Cripto cripto9 = new Cripto(8,"DOT","POLKADOT", 129f,0);
        
        Fiat real = new Fiat(0, "BRL", "REAL", 1,2000);
        
       
        
        
        
        //Adiciona Elementos na lista
        
        usuario.add(usuario1);
        usuario.add(usuario2);
        
        
        cripto.add(cripto1);
        cripto.add(cripto2);
        cripto.add(cripto3);
        cripto.add(cripto4);
        cripto.add(cripto5);
        cripto.add(cripto6);
        cripto.add(cripto7);
        cripto.add(cripto8);
        cripto.add(cripto9);
                
        fiat.add(real);
                
        
        
        

        
       
    }
    
}
