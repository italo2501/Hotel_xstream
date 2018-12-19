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

/**
 *
 * @author italo
 */
public class RomariaBD {
    private static ArrayList<Romaria> lista = new ArrayList<Romaria>();
    private static final String caminho = "C:\\hote_bd\\";
    
    public static void inserir(Romaria novaRomaria) {
        lerXml();
        lista.add(novaRomaria);
        salvarXml();
    }

    public static void alterar(Romaria romariaAlterada) {

        excluir(romariaAlterada.getCodigo());
        inserir(romariaAlterada);

    }

    public static void excluir(int codigo) {
        lerXml();
        for (int i = 0; i < lista.size(); i++) {
            Romaria cadaRomaria = lista.get(i);
            if (cadaRomaria.getCodigo() == codigo){

                lista.remove(i);
                break;
            }

        }
    }

    public static ArrayList<Romaria> listar() {
        lerXml();
        return lista;

    }  
    //pega o que está no XML e coloca na lista
    public static void lerXml() {

        File arquivo = new File(caminho + "romarias.xml");
        if (arquivo.exists()) {
            //armazer XML no vertor
            XStream xstream = new XStream();
            xstream.alias("romaria", Lider.class);
            lista = (ArrayList<Romaria>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<>();
        }

    }

    //pega o que está no vetor e joga no XML
    public static void salvarXml() {

        XStream xstream = new XStream();
        xstream.alias("romaria", Lider.class);
        try {
            FileWriter escritor = new FileWriter(caminho + "romarias.xml");
            escritor.write(xstream.toXML(lista));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
