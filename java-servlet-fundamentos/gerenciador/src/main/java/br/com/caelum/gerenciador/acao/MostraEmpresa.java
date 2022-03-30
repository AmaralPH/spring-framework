package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		System.out.println("Mostrando empresa " + id);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.getEmpresaById(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditaEmpresa.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher("formEditaEmpresa.jsp");
//		rd.forward(request, response);
	}

}
