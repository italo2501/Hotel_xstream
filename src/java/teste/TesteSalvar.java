/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dominio.Lider;
import dominio.Reserva;
import dominio.Romaria;
import persistencia.LiderBD;
import persistencia.ReservaBD;
import persistencia.RomariaBD;

/**
 *
 * @author italo
 */
public class TesteSalvar {
    public static void main(String[] args) {
        Lider lider = new Lider();
        lider.setNome("Goku");
        lider.setCpf("123");
        LiderBD.inserir(lider);
        
        Reserva reserva = new Reserva();
        reserva.setQuantidadeDiarias(16);
        ReservaBD.inserir(reserva);
        
        Romaria romaria = new Romaria();
        romaria.setQuantidadeCasais(10);
        romaria.setQuantidadeCriancas(4);
        romaria.setQuantidadeSolteiros(2);
        RomariaBD.inserir(romaria);
                
        
        
        
        
        
        System.out.println("Cadastrado com sucesso!");
    }
}
