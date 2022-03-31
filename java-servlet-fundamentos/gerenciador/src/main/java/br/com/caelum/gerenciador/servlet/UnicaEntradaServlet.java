package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.Acao;

/**
 * Servlet implementation class ControlaEntrada
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrada");
		
		String paramAcao = request.getParameter("acao");
		
		String enderecoClasse = "br.com.caelum.gerenciador.acao." + paramAcao;
		
		String nome = null;
		try {
			Class classe = Class.forName(enderecoClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String[] TipoEEndereco = nome.split(":");
		
		if (TipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + TipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(TipoEEndereco[1]);
		}
		
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

	}

}
