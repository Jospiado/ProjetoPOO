/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.Helper.DepositarHelper;
import Model.DAO.ServicoBD;
import Model.Servico;
import View.Depositar;
import View.MenuPrincipal;
import javax.swing.JOptionPane;


public class DepositarController {
       private Depositar view;
       private DepositarHelper helper;
       private float valor;
       private String data;

    public DepositarController(Depositar view) {
        this.view = view;
        this.helper = new DepositarHelper(view);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
   
       
    public void deposito(){
                float valor = Float.parseFloat(view.getValorRS().getText());
                String data = view.getData().getText();
        
                this.setValor(valor);
                this.setData(data);
                
                
                MenuPrincipal menu = new MenuPrincipal();
                
                menu.exportarnomeedata(this, this);   
                
                view.dispose();
                
                menu.setVisible(true);
                
                
    }
        
        
 }   
