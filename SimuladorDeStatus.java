
package StatusHTTP;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testar-status")
public class SimuladorDeStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String status = req.getParameter("codigo");
        int codigo = 200; // padrão

        if (status != null) {
            switch (status) {
                case "404":
                    codigo = HttpServletResponse.SC_NOT_FOUND;
                    break;
                case "500":
                    codigo = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
                    break;
                case "200":
                default:
                    codigo = HttpServletResponse.SC_OK;
                    break;
            }
        }

        resp.setStatus(codigo);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>Status HTTP enviado: " + codigo + "</h2>");
        out.println("</body></html>");
    }
}
