/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.thoughtworks.xstream.XStream;
import dominio.Funcionario;
import dominio.Lider;
import dominio.Reserva;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class FuncionarioBD {
    
     private static ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
    private static final String caminho = "C:\\hote_bd\\";
   
    
    
    public static void inserir(Funcionario novoFuncionario) {
        lerXml();
        lista.add(novoFuncionario);
        salvarXml();
    }

    public static void alterar(Funcionario funcionarioAlterado) {

        excluir(funcionarioAlterado.getCodigo());
        inserir(funcionarioAlterado);

    }

    public static void excluir(int codigo) {
        lerXml();
        for (int i = 0; i < lista.size(); i++) {
            Funcionario cadaFuncionario = lista.get(i);
            if (cadaFuncionario.getCodigo() == codigo){

                lista.remove(i);
                break;
            }

        }
    }

    public static ArrayList<Funcionario> listar() {
        lerXml();
        return lista;

    }  
   
  //pega o que está no XML e coloca na lista
    public static void lerXml() {

        File arquivo = new File(caminho + "funcionarios.xml");
        if (arquivo.exists()) {
            //armazer XML no vertor
            XStream xstream = new XStream();
            xstream.alias("funcionario", Lider.class);
            lista = (ArrayList<Funcionario>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<>();
        }

    }

    //pega o que está no vetor e joga no XML
    public static void salvarXml() {

        XStream xstream = new XStream();
        xstream.alias("funcionario", Lider.class);
        try {
            FileWriter escritor = new FileWriter(caminho + "funcionarios.xml");
            escritor.write(xstream.toXML(lista));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
   public static Funcionario procurarPorLoginSenha(String login, String senha) {
       lerXml();
       Funcionario funcionarioEcontrado = null;
        for (int i = 0; i < lista.size(); i++) {
            Funcionario funcionario = lista.get(i);

            if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {

                funcionarioEcontrado = funcionario;
                break;
            }

        }
        return funcionarioEcontrado;
    }
    
}