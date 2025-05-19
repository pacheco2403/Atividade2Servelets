
package SessaoGerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gerenciar-sessao")
public class GerenciadorDeSessao extends HttpServlet {

    private static final String IDENTIFICADOR_COOKIE = "nomeUsuario";

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {
        resposta.setContentType("text/html");
        PrintWriter escritor = resposta.getWriter();

        String nomeUsuario = null;
        Cookie[] listaCookies = requisicao.getCookies();

        if (listaCookies != null) {
            for (Cookie item : listaCookies) {
                if (IDENTIFICADOR_COOKIE.equals(item.getName())) {
                    nomeUsuario = item.getValue();
                    break;
                }
            }
        }

        if (nomeUsuario != null) {
            escritor.println("<html><body>");
            escritor.println("<h2>Bem-vindo de volta, " + nomeUsuario + "!</h2>");
            escritor.println("</body></html>");
        } else {
            nomeUsuario = requisicao.getParameter("nome");
            if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
                Cookie novoCookie = new Cookie(IDENTIFICADOR_COOKIE, nomeUsuario);
                novoCookie.setMaxAge(60 * 60 * 24);
                resposta.addCookie(novoCookie);

                escritor.println("<html><body>");
                escritor.println("<h2>Olá, " + nomeUsuario + "! Seu nome foi salvo com sucesso.</h2>");
                escritor.println("</body></html>");
            } else {
                escritor.println("<html><body>");
                escritor.println("<h2>Nome de usuário não fornecido.</h2>");
                escritor.println("</body></html>");
            }
        }
    }
}
