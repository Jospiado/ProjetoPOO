/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


abstract public class Moeda {
        
        private String cod;
        private String nome;
        private float preco_unidade;
    
    
    
    public Moeda(String cod, String nome, float preco_unidade) {
        this.cod = cod;
        this.nome = nome;
        this.preco_unidade = preco_unidade;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(float preco_unidade) {
        this.preco_unidade = preco_unidade;
    }
    
    
    
        
}
