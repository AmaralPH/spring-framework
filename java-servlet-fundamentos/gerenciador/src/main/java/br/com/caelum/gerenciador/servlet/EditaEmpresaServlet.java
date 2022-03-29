package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditaEmpresaServlet
 */
@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Editando empresa!");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);

		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");
		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		banco.editaEmpresa(id, nomeEmpresa, dataAbertura);
		
		response.sendRedirect("listaEmpresas");
	}

}
