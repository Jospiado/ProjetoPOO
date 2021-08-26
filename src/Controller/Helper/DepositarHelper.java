/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Helper;

import Model.Fiat;
import Model.Servico;
import View.Depositar;
import View.MenuPrincipal;


public class DepositarHelper implements Helper{
       private Depositar view;
    public DepositarHelper(Depositar view){
        this.view = view;
    }

  
       
      public Servico obterdeposito(float valor , String data){
        float valorthis = valor;
        float quantia = valor;
        float precototal = valor;
        float precototalbtc = valor/242000;
        String datathis = data;
        Fiat fiat = new Fiat(0, "BRL", "Real", 1, 2000);
        
        Servico deposito = new Servico(fiat.getCod(),fiat.getNome(),"Depósito", datathis ,fiat , quantia, precototal, precototalbtc, fiat.getPreco_unidade());
        
        return deposito;                                     
    }     
    //Sobrescrita de métodos

    @Override
    public void limpartela() {
     }

    @Override
    public Object obtermodelo() {
           return null;
    }

    @Override
    public void exibirmensagem() {
 
     }
}
