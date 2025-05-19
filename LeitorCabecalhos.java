
package CabecalhoHTTP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ver-cabecalhos")
public class LeitorCabecalhos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cabeçalhos da Requisição:</h2>");
        out.println("<ul>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nome = headerNames.nextElement();
            String valor = req.getHeader(nome);
            out.println("<li><b>" + nome + "</b>: " + valor + "</li>");
        }

        out.println("</ul>");
        out.println("<p><b>IP:</b> " + req.getRemoteAddr() + "</p>");
        out.println("<p><b>Protocolo:</b> " + req.getProtocol() + "</p>");
        out.println("</body></html>");
    }
}
