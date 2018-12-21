/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dominio.Funcionario;
import persistencia.FuncionarioBD;

/**
 *
 * @author italo
 */
public class CadastrarFuncionario {
       public static void main(String[] args) {
        
           Funcionario funcionario = new Funcionario();
           funcionario.setLogin("admin");
           funcionario.setSenha("admin");
           funcionario.setCodigo(1);
           FuncionarioBD.inserir(funcionario);
    }
}
