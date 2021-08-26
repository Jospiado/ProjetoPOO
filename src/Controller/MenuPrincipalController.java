/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.Helper.MenuPrincipalHelper;
import Model.Cripto;
import Model.DAO.CriptoBD;
import Model.DAO.ServicoBD;
import Model.Fiat;
import Model.Servico;
import View.Depositar;
import View.MenuPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MenuPrincipalController {
    private MenuPrincipal view;
    private MenuPrincipalHelper helper;
    
    
    
    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MenuPrincipalHelper(view);
    }
    
    public void setarvalorPatrimonio(){
        float saldo = helper.obterSALDO();
        float saldobtc = helper.obterSALDOBTC();
        
        view.getValorreal().setText(saldo+"");
        view.getValorbtc().setText(saldobtc+"");
    }
    public void setarcriptos(){
        CriptoBD criptobd = new CriptoBD();
        ArrayList<Cripto> criptos = criptobd.selectAll();
        
        helper.preenchercriptos(criptos);
    }
    public void setaremcarteira(){
        
        Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
        
        view.getTextemcarteira().setText(cripto.getEmcarteira()+"");
    }
    public void setarpreco(){
         Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
         
        float quantia = Float.parseFloat(view.getQuantia().getText());
         
        float preco = cripto.getPreco_unidade()*quantia;
                     
        view.getPreco().setText(preco+"");

    }
    public void atualizartabelacompra(){
        //buscar lista com as compras no banco de dados
        ServicoBD CompraBD = new ServicoBD();
        ArrayList<Servico> compras = CompraBD.selectAll();
        //exibir lista na view
        helper.preenchertabela(compras);
    }
    public void atualizartabelavenda(){      
        //buscar lista com as vendas no banco de dados
        ServicoBD VendaBD = new ServicoBD();
        ArrayList<Servico> vendas = VendaBD.selectAll();
        
        //exibir lista na view
        helper.preenchertabela(vendas);
    }
    public void atualizartabeladeposito(){
        //buscar lista com os depositos no banco de dados
        ServicoBD DepositoBD = new ServicoBD();
        ArrayList<Servico> depositos = DepositoBD.selectAll();
        
        //exibir lista na view
        helper.preenchertabela(depositos);
    }
    public void compra(){
        Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
        float valorsaldo = Float.parseFloat(view.getValorreal().getText());
        float preco = Float.parseFloat(view.getPreco().getText());
        float quantidade = Float.parseFloat(view.getQuantia().getText());
        
        if(valorsaldo>=preco){
        
        //buscar objeto servico compra da tela
        Servico compra = helper.obtercompra();
        
        //salvar no bd
        new ServicoBD().insert(compra);
            
        atualizartabelacompra();      
        // mudar os valores da tela
        
        view.getValorreal().setText(valorsaldo-preco+"");
        float valorbtc = (valorsaldo)/242000;
        view.getValorbtc().setText(valorbtc+"");
        
        CriptoBD criptos = new CriptoBD();
        
        Cripto criptodeagora = criptos.selectEspc(cripto.getId());
        criptodeagora.setEmcarteira(criptodeagora.getEmcarteira()+quantidade);
            
        JOptionPane.showMessageDialog(null,"Compra Realizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }
        helper.limpartela();
    }
        public void venda(){  
        
        Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
        float valorsaldo = Float.parseFloat(view.getValorreal().getText());
        float preco = Float.parseFloat(view.getPreco().getText())*1.05f;
        float quantidade = Float.parseFloat(view.getQuantia().getText());
        
        if(quantidade<=cripto.getEmcarteira()){
        
        //buscar objeto servico venda da tela
        Servico venda = helper.obtervenda();
        
        //salvar no bd
        new ServicoBD().insert(venda);
            
        atualizartabelavenda();      
        // mudar os valores da tela
        view.getValorreal().setText(valorsaldo+preco+"");
        float valorbtc = Float.parseFloat(view.getValorreal().getText())/242000;
        view.getValorbtc().setText(valorbtc+"");
        CriptoBD criptos = new CriptoBD();
        
        Cripto criptodeagora = criptos.selectEspc(cripto.getId());
        criptodeagora.setEmcarteira(criptodeagora.getEmcarteira()-quantidade);
            
        JOptionPane.showMessageDialog(null,"Venda Realizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Criptos em carteira, insuficientes!");
        }
        helper.limpartela();
        }
        public void deposito(float valor , String data){
        float valorsaldo = Float.parseFloat(view.getValorreal().getText());
                      
        //buscar objeto servico venda da tela
        Servico deposito = helper.obterdeposito(valor, data);
        float valordepositado = deposito.getValor_operacao();
        //salvar no bd
        new ServicoBD().insert(deposito);
            
        atualizartabeladeposito();    
        // mudar os valores da tela
        
        view.getValorreal().setText(valorsaldo+valordepositado+"");
        float valorbtc = Float.parseFloat(view.getValorreal().getText())/242000;
        view.getValorbtc().setText(valorbtc+"");
                         
            
        JOptionPane.showMessageDialog(null,"Depósito realizado com sucesso");
        
        }
        
        public void navegarparadeposito(){
            Depositar d = new Depositar();
            d.setVisible(true);
            view.dispose();
        }
 }
 
    
