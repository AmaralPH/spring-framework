package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;

public class AlteraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
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
		
		System.out.println("acao AlteraEmpresa " + id);
		
		Banco banco = new Banco();
		banco.editaEmpresa(id, nomeEmpresa, dataAbertura);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
