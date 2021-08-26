package Model.DAO;

import Model.Fiat;
import java.util.ArrayList;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class FiatBD{
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param fiat exige que seja passado um objeto do tipo compra
     */
    public void insert(Fiat venda){
          
        
            venda.setId(proximoId());
            Banco.fiat.add(venda);
        
        
        
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param fiat
     * @return 
     */
    public boolean update(Fiat fiat){
        
        for (int i = 0; i < Banco.fiat.size(); i++) {
            if(idSaoIguais(Banco.fiat.get(i),fiat)){
                Banco.fiat.set(i, fiat);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param fiat
     * @return 
     */
    public boolean delete(Fiat fiat){
        for (Fiat fiatLista : Banco.fiat) {
            if(idSaoIguais(fiatLista,fiat)){
                Banco.fiat.remove(fiatLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Fiat> selectAll(){
        return Banco.fiat;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param fiat
     * @param fiatAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Fiat fiat, Fiat fiatAComparar) {
        return fiat.getId() ==  fiatAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Fiat fiat : Banco.fiat) {           
           int id = fiat.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
    
}
