/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;


public class Usuario {
        int id;
        String nome;
        String senha;
        float saldo;
        float saldo_btc;

    public Usuario(String nome, String senha, float saldo, float saldo_btc) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
        this.saldo_btc = saldo_btc;
    }
       
        
        
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo_btc() {
        return saldo_btc;
    }

    public void setSaldo_btc(float saldo_btc) {
        this.saldo_btc = saldo_btc;
    }
        
}
