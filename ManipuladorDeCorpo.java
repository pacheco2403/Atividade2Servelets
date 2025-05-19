
package CorpoRequisicao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/receber-dados")
public class ManipuladorDeCorpo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws ServletException, IOException {

        resposta.setContentType("text/html");
        PrintWriter escritor = resposta.getWriter();

        StringBuilder conteudoRecebido = new StringBuilder();
        String linha;

        try (BufferedReader leitor = requisicao.getReader()) {
            while ((linha = leitor.readLine()) != null) {
                conteudoRecebido.append(linha);
            }
        }

        escritor.println("<html><body>");
        escritor.println("<h2>Conteúdo recebido:</h2>");
        escritor.println("<pre>" + conteudoRecebido.toString() + "</pre>");
        escritor.println("</body></html>");
    }
}
