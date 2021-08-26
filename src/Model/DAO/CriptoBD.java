package Model.DAO;

import Model.Cripto;
import java.util.ArrayList;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class CriptoBD {
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param cripto exige que seja passado um objeto do tipo cripto
     */
    public void insert(Cripto cripto){
          
        
            cripto.setId(proximoId());
            Banco.cripto.add(cripto);
        
        
        
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cripto
     * @return 
     */
    public boolean update(Cripto cripto){
        
        for (int i = 0; i < Banco.cripto.size(); i++) {
            if(idSaoIguais(Banco.cripto.get(i),cripto)){
                Banco.cripto.set(i, cripto);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param cripto
     * @return 
     */
    public boolean delete(Cripto cripto){
        for (Cripto criptoLista : Banco.cripto) {
            if(idSaoIguais(criptoLista,cripto)){
                Banco.cripto.remove(criptoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Cripto> selectAll(){
        return Banco.cripto;
    }
    public Cripto selectEspc(int id){
        return Banco.cripto.get(id);
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param agendamento
     * @param agendamentoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Cripto cripto, Cripto criptoAComparar) {
        return cripto.getId() ==  criptoAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Cripto cripto : Banco.cripto) {           
           int id = cripto.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
    
}
