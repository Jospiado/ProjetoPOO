/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Helper;

import Model.Cripto;
import static Model.DAO.Banco.usuario;
import Model.DAO.UsuarioBD;
import Model.Fiat;
import Model.Servico;
import Model.Usuario;
import View.Depositar;
import View.MenuPrincipal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MenuPrincipalHelper implements Helper{
    private MenuPrincipal view;  
   
    public MenuPrincipalHelper(MenuPrincipal view) {
        this.view = view;
    }
    
  
    public float obterSALDO() {
        //digitar um usuario aleatorio
        Usuario u = new Usuario("joao", "joao", 2000,0.0082644f);
        //buscar no banco de dados
        UsuarioBD usuariobd= new UsuarioBD();
        Usuario usuarioautenticado = usuariobd.selectPorNomeESenha(u);
        
        
        
        return usuarioautenticado.getSaldo();
                   
    }
    public float obterSALDOBTC(){
        Usuario u = new Usuario("joao", "joao", 2000,0.0082644f);
        //buscar no banco de dados
        UsuarioBD usuariobd= new UsuarioBD();
        Usuario usuarioautenticado = usuariobd.selectPorNomeESenha(u);
        
        
        
        return usuarioautenticado.getSaldo_btc();
    }
    public void preenchercriptos(ArrayList<Cripto> criptos){
        DefaultComboBoxModel setarmodelos = (DefaultComboBoxModel) view.getCombomoedas().getModel();
        
        //percorrer o comobobox preenchendo
        for (Cripto cripto : criptos) {
            setarmodelos.addElement(cripto);
        }
    }

    public Servico obtercompra() {
         //buscar objeto servico (compra na tela)
        float saldoreal = Float.parseFloat(view.getValorreal().getText());
        float valorbtc = Float.parseFloat(view.getValorbtc().getText());
        float quantia = Float.parseFloat(view.getQuantia().getText());
        float precototal = Float.parseFloat(view.getPreco().getText());
        float precototalbtc = precototal/242000;
        String data = view.getData().getText();
        Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
        String nome = cripto.getNome();
        String cod = cripto.getCod();
        float valorunitario = cripto.getPreco_unidade();
        Servico compra = new Servico(cod, nome,"Compra", data, cripto, quantia, precototal ,precototalbtc ,valorunitario);
        
        return compra;    
    }
    public Servico obtervenda() {
     //buscar objeto servico (venda na tela)
        float saldoreal = Float.parseFloat(view.getValorreal().getText());
        float valorbtc = Float.parseFloat(view.getValorbtc().getText());
        float quantia = Float.parseFloat(view.getQuantia().getText());
        float precototal = Float.parseFloat(view.getPreco().getText())*1.05f;
        float precototalbtc = precototal/242000;
        String data = view.getData().getText();
        Cripto cripto= (Cripto) view.getCombomoedas().getSelectedItem();
        String nome = cripto.getNome();
        String cod = cripto.getCod();
        float valorunitario = cripto.getPreco_unidade()*1.05f;
        Servico venda = new Servico(cod, nome,"Venda", data, cripto, quantia, precototal ,precototalbtc ,valorunitario);
        
        return venda;    
    
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

    public void preenchertabela(ArrayList<Servico> servico) {
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getTabela().getModel();
        tabelmodel.setNumRows(0);
        
        //percorrer a lista preenchendo o servico
        for (Servico servico1 : servico) {
            tabelmodel.addRow(new Object[]{
                servico1.getCod_moeda(),
                servico1.getNome_moeda(),
                servico1.getDescricao(),
                servico1.getQuantidade_operacao(),
                servico1.getData(),
                servico1.getValor_operacao(),
                servico1.getValorunico_moeda(),
                servico1.getValor_operacaoBTC()               
                          
            });
        }
    }
        public void limpartela(){
        
        view.getQuantia().setText("");
        view.getPreco().setText("");
        view.getData().setText("");
        
       
      }    
    //Sobrescrita de métodos

    @Override
    public Object obtermodelo() {
        
        return null;
        
    }

    @Override
    public void exibirmensagem() {
    }
}
