/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.Helper.LoguinHelper;
import Model.DAO.UsuarioBD;
import Model.Usuario;
import View.Loguin;
import View.MenuPrincipal;


public class LoguinController {

    private final Loguin view;
    private LoguinHelper helper;

    public LoguinController(Loguin view) {
        this.view = view;
        this.helper= new LoguinHelper(view);
    }
    
    
    public void entrarnomenu(){
        //pegar usuario da view
        Usuario usuario = helper.obtermodelo();
        //buscar no banco de dados
        UsuarioBD usuariobd= new UsuarioBD();
        Usuario usuarioautenticado = usuariobd.selectPorNomeESenha(usuario);
        
         //se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco, direcionar para menu
        //senao mostrar uma mensagem ao usuario "Usuario e senha invalidos"
        if(usuarioautenticado != null){
            //navegar para menuprincipal
            MenuPrincipal m = new MenuPrincipal();
            m.setVisible(true);
            this.view.dispose();
        }else{
            helper.limpartela();
            helper.exibirmensagem("Usuário ou senha invalidos");
        }
    
    }
}
