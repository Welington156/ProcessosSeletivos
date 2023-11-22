/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author cauaq
 */
@WebServlet(name = "MostrarDadosServlet", urlPatterns = "/mostrar-dados")
public class MostrarDadosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dados do Sistema</title>");
            out.println("</head>");
            out.println("<body>");

            // Mostrar dados do sistema
            out.println("<h1>Usuários:</h1>");
            // ... mostrar detalhes dos usuários

            out.println("<h1>Processos Seletivos:</h1>");
            // ... mostrar detalhes dos processos seletivos

            out.println("<h1>Postagens:</h1>");
            // ... mostrar detalhes das postagens

            out.println("</body>");
            out.println("</html>");
        }
    }
}
