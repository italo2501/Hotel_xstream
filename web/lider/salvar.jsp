<%-- 
    Document   : salvar
    Created on : 19/12/2018, 21:51:16
    Author     : italo
--%>

<%@page import="persistencia.LiderBD"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Líderes</title>
    </head>
    <body>
        
        <%
            String idAlterado = request.getParameter("idAlterado");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String dataNascimento = request.getParameter("dataNascimento");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dataNascimento);
            
            Lider lider;
            if(idAlterado != "null"){
                
                lider = LiderBD.getByCpf(cpf);
            }else {
                
                 lider = new Lider();
            }
            
           
            lider.setNome(nome);
            lider.setCpf(cpf);
            lider.setTelefone(telefone);
            lider.setDataNascimento(data);
            lider.setCidade(cidade);
            lider.setEstado(estado);
            LiderBD.inserir(lider);
           
            if (idAlterado != "null"){
                
                LiderBD.alterar(lider);
                out.println("Lider alterado com sucesso!");
            }else{
                
                LiderBD.inserir(lider);
                out.println("Lider cadastrado com sucesso!");
            }


            %>
            Lider cadastrado com sucesso!
            <br />
            
         
    </body>
</html>
