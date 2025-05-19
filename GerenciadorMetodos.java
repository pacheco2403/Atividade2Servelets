
package ControladorHTTP;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/operacoes-suportadas")
public class GerenciadorMetodos extends HttpServlet {

    @Override
    protected void doOptions(HttpServletRequest requisicao, HttpServletResponse resposta) {
        resposta.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
    }

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {
        resposta.setContentType("text/plain");
        PrintWriter escritor = resposta.getWriter();
        escritor.println("Requisição GET recebida com sucesso.");
    }

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {
        resposta.setContentType("text/plain");
        PrintWriter escritor = resposta.getWriter();
        escritor.println("Requisição POST processada corretamente.");
    }

    @Override
    protected void doPut(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {
        resposta.setContentType("text/plain");
        PrintWriter escritor = resposta.getWriter();
        escritor.println("Requisição PUT tratada adequadamente.");
    }

    @Override
    protected void doDelete(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {
        resposta.setContentType("text/plain");
        PrintWriter escritor = resposta.getWriter();
        escritor.println("Requisição DELETE executada com êxito.");
    }
}
