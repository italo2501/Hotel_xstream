/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Lider;
import dominio.Reserva;
import dominio.Romaria;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import static persistencia.LiderBD.lerXml;



/**
 *
 * @author italo
 */
public class ReservaBD {
        
    private static ArrayList<Reserva> lista = new ArrayList<Reserva>();
    private static final String caminho = "C:\\hote_bd\\";
   
    
    
    public static void inserir(Reserva novaReserva) {
        lerXml();
        lista.add(novaReserva);
        salvarXml();
    }

    public static void alterar(Reserva reservaAlterada) {

        excluir(reservaAlterada.getCodigo());
        inserir(reservaAlterada);

    }

    public static void excluir(int codigo) {
        lerXml();
        for (int i = 0; i < lista.size(); i++) {
            Reserva cadaReserva = lista.get(i);
            if (cadaReserva.getCodigo() == codigo){

                lista.remove(i);
                break;
            }

        }
    }

    public static ArrayList<Reserva> listar() {
        lerXml();
        return lista;

    }  
   
  //pega o que está no XML e coloca na lista
    public static void lerXml() {

        File arquivo = new File(caminho + "reservas.xml");
        if (arquivo.exists()) {
            //armazer XML no vertor
            XStream xstream = new XStream();
            xstream.alias("reserva", Lider.class);
            lista = (ArrayList<Reserva>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<>();
        }

    }

    //pega o que está no vetor e joga no XML
    public static void salvarXml() {

        XStream xstream = new XStream();
        xstream.alias("reserva", Lider.class);
        try {
            FileWriter escritor = new FileWriter(caminho + "reservas.xml");
            escritor.write(xstream.toXML(lista));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
