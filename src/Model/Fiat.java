/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


public class Fiat extends Moeda{
    int id;
    float emcarteira;
    public Fiat(int id,String cod, String nome, float preco_unidade, float emcarteira) {
        super(cod, nome, preco_unidade);
        this.id=id;
        this.emcarteira=emcarteira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getEmcarteira() {
        return emcarteira;
    }

    public void setEmcarteira(float emcarteira) {
        this.emcarteira = emcarteira;
    }

   
}
